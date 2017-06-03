package servlet;


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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.BattleManagerDAO;
import DAO.RaceDAO;
import model.BattleManager;
import model.Race;
import model.User;
@Controller
public class RaceControl {
	RaceDAO rd=new RaceDAO();
	BattleManagerDAO bmd=new BattleManagerDAO();
//race 的增删改查 全拉  参加 新增管理员 查看以参加人员 写完返回去写用户查看已参加比赛 
	
	
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
			if(listall.get(i).getRacestate()==1){
				listnoopen.add(listall.get(i));
			}
		}
		
		return listnoopen;
	}
	
	@RequestMapping(value = "detial.do", method = RequestMethod.POST)
	public String detialrace(@RequestParam("raceid")int raceid){
		Race race=rd.searchracebyid(raceid);
		switch (race.getRacestate()) {
		case 1:{return "noopenrace"; }
		case 2:{return "isopenrace"; }
		case 3:{return "isendrace"; }	
		}
		return null;
		
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
