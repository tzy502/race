package controller;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
	RaceDAO rd=new RaceDAO();
	BattleManagerDAO bmd=new BattleManagerDAO();
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(@RequestParam("userid")String userid,@RequestParam("pwd")String pwd,Model model,HttpServletRequest request){
		System.out.println(userid);
		System.out.println(pwd);

		if(userid.isEmpty()==true){
			try {
				throw new Exception("请输入帐号");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		if(pwd.isEmpty()==true){
			try {
				throw new Exception("请输入密码");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		User user=new User();
		user.setUserid(userid);
		user.setPwd(pwd);
		if(ud.login(user)==true){
			user=ud.Searchuserbyid(userid);
			model.addAttribute("user",user);
			HttpSession session = request.getSession();  
			session.setAttribute("user",user);  
			System.out.println(user.getUsername()+"来自control");
			return "index";
		}
		else
			try {
				throw new Exception("帐号密码错误");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());

				return "error";
			}

	}
	@RequestMapping(value = "modifypwd.do", method = RequestMethod.POST)
	public String modifypwd(HttpServletRequest request,@RequestParam("oldpwd")String oldpwd,
			@RequestParam("newpwd1")String newpwd1,@RequestParam("newpwd2")String newpwd2){
		User user=(User) request.getSession().getAttribute("user");
		if(user.getPwd().equals(oldpwd)){
			if(newpwd1.equals(newpwd2)){
				user.setPwd(newpwd1);
				ud.modifyuser(user);
				return "ok";
			}
			else{
				try{	
					throw new Exception("新密码两次不统一");
				}
				catch(Exception e)
				{
					e.printStackTrace();
					request.setAttribute("errormsg", e.getMessage());
					return "error";
				}
			}
		}
		else{
			try{	
				throw new Exception("新旧密码不一样");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		
		
	}	@RequestMapping(value = "modifyuser.do", method = RequestMethod.POST)
	public String modifyuser(@RequestParam("username")String username,@RequestParam("QQ")String QQ,@RequestParam("TEL")String TEL
			,HttpServletRequest request){
		if(username.isEmpty()==true){
			try {
				throw new Exception("请输入帐号");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		System.out.println("from modifyuser dao");
		User user =(User) request.getSession().getAttribute("user");
		user.setQQ(QQ);
		user.setUsername(username);
		user.setTEL(TEL);
		ud.modifyuser(user);
		return "ok";
	}
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String register(@RequestParam("userid")String userid,@RequestParam("pwd")String pwd
			,@RequestParam("username")String username,@RequestParam("QQ")String QQ,@RequestParam("TEL")String TEL
			,HttpServletRequest request){

		if(userid.isEmpty()==true){
			try {
				throw new Exception("请输入帐号");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		if(pwd.isEmpty()==true){
			try {
				throw new Exception("请输入密码");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		if(username.isEmpty()==true){
			try {
				throw new Exception("请输入昵称");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}
		User user =new User();
		user.setUserid(userid);
		user.setPwd(pwd);
		user.setUsername(username);
		user.setQQ(QQ);
		user.setTEL(TEL);
		user.setType(2);
		if(ud.Searchuserbyid(userid)==null){
			ud.register(user);
			return "login";
		}
		else{
			try {
				throw new Exception("帐号已经重复");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("errormsg", e.getMessage());
				return "error";
			}
		}

	}
	@RequestMapping(value = "quit.do", method = RequestMethod.POST)
	public String quit(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "login";
	}
	public void changeutf8(User user){
		
	}

}
