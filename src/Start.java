import DAO.UserDAO;
import model.User;

public class Start {

	public static void main(String[] args) {
		UserDAO lg=new UserDAO();
//		String user="tzy";
//		String pwd="502";
//		User user2=new User();
//		user2.setUserid(user);
//		user2.setPwd(pwd);
//		user2.setUsername("tzy502");
//		user2.setQQ("123");
//		user2.setTEL("123");	
//		try {
//			lg.register(user2);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		User user1=new User();
		user1.setUserid("admin");
		user1.setPwd("admin123123");
		lg.login(user1);
//		
//		System.out.println(lg.Searchuserbyid("tzy").getUsername());
		
	}
	

}
