package servlet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.RaceDAO;
import model.Race;

public class RaceControl {
	RaceDAO rd=new RaceDAO();
//race 的增删改查 全拉  参加 新增管理员 查看以参加人员 写完返回去写用户查看已参加比赛 
	@RequestMapping(value = "addrace.do", method = RequestMethod.POST)
	public String addrace(@RequestParam("racename") String racename,@RequestParam("racetype") int racetype
			,@RequestParam("racestate")String racestate,@RequestParam("introduction")String introduction,@RequestParam("raceaddress")String raceaddress,HttpServletRequest request){
		try {
			racecheck(racename, racetype, introduction, raceaddress);
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
		rd.addrace(race);
		return "ok";
	}
	
	public boolean racecheck( String racename,int racetype,String introduction,String raceaddress) throws Exception{
		if(racename.isEmpty()==true){
			throw new Exception("请输入比赛名");
		}
		if(introduction.isEmpty()==true){
			throw new Exception("请输入介绍");
		}	
		if(raceaddress.isEmpty()==true){
			throw new Exception("请输入比赛地点");
		}	
		return true;
	}
}
