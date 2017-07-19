package controller;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.BattleLogDAO;
import DAO.BattleManagerDAO;
import DAO.BattleTableDAO;
import DAO.RaceDAO;
import model.BattleLog;
import model.BattleManager;
import model.BattleTable;
import model.Race;
import model.User;
@Controller
public class RaceControl {
	RaceDAO rd=new RaceDAO();
	BattleManagerDAO bmd=new BattleManagerDAO();
	BattleTableDAO btd=new BattleTableDAO();
	BattleLogDAO bld=new BattleLogDAO();
//race 的增删改查 全拉  参加 新增管理员 查看以参加人员 写完返回去写用户查看已参加比赛 
	@RequestMapping(value = "raceing.do", method = RequestMethod.POST)
	public String raceing(@RequestParam("raceid")int raceid,@RequestParam("totalrace")int totalrace,@RequestParam("lucky")String lucky
			,HttpServletRequest request){
		String win;
		BattleLog bl=new BattleLog();
		List<BattleTable> allbattle =new ArrayList<BattleTable>();
		allbattle=(List<BattleTable>)request.getSession().getAttribute("battle");
		BattleTable user1=new BattleTable();
		BattleTable user2=new BattleTable();
		BattleTable luckyplayer=new BattleTable();
		if(lucky!="-1"){
			luckyplayer=allbattle.get(allbattle.size()-1);
			luckyplayer.setWin(luckyplayer.getWin()+1);
			btd.modify(luckyplayer);
			bl.setBattleuserid1(luckyplayer.getUserid());
			bl.setBattleuserid2(null);
			bl.setBattleusername1(luckyplayer.getUsername());
			bl.setBattleusername2("轮空");
			bl.setRaceid(raceid);
			bl.setWhowin(1);
			bld.add(bl);
		}
		for(int i=1;i<=totalrace;i++){
			win=request.getParameter("the"+i+"win");
			int whowin;
			if(win==null){
				try {
					throw new Exception("第"+i+"轮没有填写结果");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("errormsg", e.getMessage());
					return "error";
				}
			}
			else{
				whowin=Integer.valueOf(win);
				user1=allbattle.get(0);
				user2=allbattle.get(1);
				allbattle.remove(1);
				allbattle.remove(0);
				bl.setBattleuserid1(user1.getUserid());
				bl.setBattleuserid2(user2.getUserid());
				bl.setBattleusername1(user1.getUsername());
				bl.setBattleusername2(user2.getUsername());
				
				if(whowin==1){
					user1.setWin(user1.getWin()+1);
					user2.setLose(user2.getLose()+1);
					bl.setWhowin(1);
				}
				else{
					user1.setWin(user1.getLose()+1);
					user2.setLose(user2.getWin()+1);	
					bl.setWhowin(2);
				}
				btd.modify(user1);
				btd.modify(user2);
				bld.add(bl);
				
			}
			
		}
		battle(raceid, request);
		return "openrace";
	}
	@RequestMapping(value = "join.do", method = RequestMethod.POST)
	public String join(@RequestParam("userid")String userid,@RequestParam("username")String username,@RequestParam("raceid")int raceid,HttpServletRequest request){
		BattleTable bt=new BattleTable();
		bt.setRaceid(raceid);
		bt.setUserid(userid);
		bt.setUsername(username);
		bt.setLose(0);
		bt.setType(0);
		bt.setWin(0);
		bt.setBattlenum("0");
		BattleTable result=new BattleTable();
		result=btd.search(raceid, userid);
		if(result!=null){
			try {
				throw new Exception("已经参加");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		btd.add(bt);
		
		return "ok";
	}
	public void battle(int raceid,HttpServletRequest request){
		Race race=new Race();
		race=rd.searchracebyid(raceid);
		List<BattleTable> battle =new ArrayList<BattleTable>() ;
		Battle bt=new Battle();
		switch (race.getRacetype()) {
			case 1:{battle=btd.loadsigner(raceid);;break;}
			case 2:{break;}
			case 3:{break;}
			case 4:{break;}
			case 5:{break;}
		}
		
		if(battle.size()==1){
			race.setRacestate(3);
			rd.modifyrace(race);
			System.out.println("比赛结束");
		}
		request.getSession().setAttribute("battle", battle);
		

	}	
	@RequestMapping(value = "addrace.do", method = RequestMethod.POST)
	public String addrace(@RequestParam("racename") String racename,@RequestParam("racetype") int racetype
			,@RequestParam("introduction")String introduction,@RequestParam("raceaddress")String raceaddress,@RequestParam("raceopendate")String raceopendatestring,HttpServletRequest request){
//		
		System.out.println(raceopendatestring+"from addrace control");
		Timestamp raceopendate = new Timestamp(0);
		raceopendate=Timestamp.valueOf(raceopendatestring);
		try {
			racecheck(racename, racetype, introduction, raceaddress,raceopendate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errormsg", e.getMessage());
			return "error";
		}
		Race race=new Race();
		race.setIntroduction(introduction);
		race.setRaceaddress(raceaddress);
		race.setRacename(racename);
		race.setRacetype(racetype);
		race.setRacestate(1);
		race.setRaceopendate(raceopendate);
		rd.addrace(race);
		User user =(User)request.getSession().getAttribute("user");
		BattleManager bm=new BattleManager();
		bm.setUserid(user.getUserid());
		bm.setRaceid(rd.searchidbyname(racename));
		bm.setIsboss(true);
		bmd.add(bm);
		return "ok";
	}
	public List<Race> load(){
		List<Race> listnoopen =new ArrayList<Race>() ;
		List<Race> listall =rd.load();
		for(int i=0;i<listall.size();i++){
				listnoopen.add(listall.get(i));		
		}	
		return listnoopen;
	}

	@RequestMapping(value = "detial.do", method = RequestMethod.POST)
	public String detialrace(@RequestParam("raceid")int raceid,HttpServletRequest request){
		HttpSession session = request.getSession();  
		List<BattleTable> result =new ArrayList<BattleTable>();
		result=btd.loadallplay(raceid);
		Race race=rd.searchracebyid(raceid);
		session.setAttribute("race",race);  
		session.setAttribute("allplay",result);  
		switch (race.getRacestate()) {
		case 1:{return "noopenrace"; }
		case 2:{battle(raceid, request);return "openrace"; }
		case 3:{return "isendrace"; }	
		}
		return null;
		
	}
	@RequestMapping(value = "openrace.do", method = RequestMethod.POST)
	public String openrace(@RequestParam("raceid")int raceid,HttpServletRequest request){
		Race race=rd.searchracebyid(raceid);
		if(race.getRacestate()==2){
			try {
				throw new Exception("比赛已经开始");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		race.setRacestate(2);
		rd.modifyrace(race);
		
		return "ok";
	}
	public boolean racecheck( String racename,int racetype,String introduction,String raceaddress,Timestamp ts) throws Exception{
		if(racename.isEmpty()==true){
			throw new Exception("请输入比赛名");
		}
		if(introduction.isEmpty()==true){
			throw new Exception("请输入介绍");
		}	
		if(raceaddress.isEmpty()==true){
			throw new Exception("请输入比赛地点");
		}	
		if(ts==null){
			throw new Exception("请输出时间");
		}			
		return true;
	}
	
	
}
