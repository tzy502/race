import java.util.ArrayList;
import java.util.List;

import DAO.RaceDAO;
import DAO.UserDAO;
import model.Race;
import model.User;
import servlet.RaceControl;

public class Start {

	public static void main(String[] args) {
		Race race=new Race();
		RaceDAO rd=new RaceDAO();
		UserDAO ud=new UserDAO();
		User user=new User();
		user.setUserid("哈哈哈");
		user.setPwd("123");
		user.setUsername("adsa");
		ud.register(user);
		RaceControl rc=new RaceControl();
	}
	

}
