package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.BattleManagerDAO;
import DAO.UserDAO;
import model.BattleManager;

@Controller
public class BattleManegerControl {
	BattleManagerDAO bmd=new BattleManagerDAO();
	UserDAO ud=new UserDAO();
	public boolean isracemanger(int raceid,String userid){
		List<BattleManager> result =new ArrayList<BattleManager>();
		result=bmd.searchallmanager(raceid);
		for(int i=0;i<result.size();i++){
			if(result.get(i).getUserid().equals(userid)==true){
				return true;
			}
		}
		return false;
	}
	@RequestMapping(value = "addmanager.do", method = RequestMethod.POST)
	public String addmanager(@RequestParam("userid")String userid,@RequestParam("raceid")int raceid,HttpServletRequest request){
		BattleManager bm=new BattleManager();
		if(ud.Searchuserbyid(userid)!=null){
			bm.setUserid(userid);
			bm.setRaceid(raceid);
			bm.setIsboss(false);
			bmd.add(bm);
			return "ok";
		}
		else{
			try {
				throw new Exception("查无此人");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		
		
	}
}
