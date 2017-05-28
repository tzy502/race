package servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import DAO.*;
import model.*;
import org.springframework.ui.Model;  
@Controller
public class UserControl {
	UserDAO ud=new UserDAO();
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(@RequestParam("userid")String userid,@RequestParam("pwd")String pwd,Model model){
		System.out.println(userid);
		System.out.println(pwd);
		
		if(userid==null){
			try {
				throw new Exception("请输入帐号");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "false";
			}
		}
		if(pwd==null){
			try {
				throw new Exception("密码错误");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "false";
			}
		}
		User user=new User();
		user.setUserid(userid);
		user.setPwd(pwd);
		if(ud.login(user)==true){
			user=ud.Searchuserbyid(userid);
			model.addAttribute(user);
			
			System.out.println(user.getUsername()+"来自control");
			return "index";
		}
		else
			try {
				throw new Exception("帐号密码错误");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "false";
			}
			
	}
}
