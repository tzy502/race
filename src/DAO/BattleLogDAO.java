package DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.BattleLog;
import model.Race;
import model.User;
import util.HibernateUtil;
public class BattleLogDAO {
	public void add(BattleLog bl){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(bl);
		session.getTransaction().commit();
	}
	public void modifylog(BattleLog bl) throws Exception{
		/*BattleLog bl=searchdetail(race,user1,user2);
		if(bl==null){
			throw new Exception("在"+race.getRacename()+"比赛中"+user1.getUsername()+"和"+user2.getUsername()+"并无对战信息");
		}*/
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(bl);
		session.getTransaction().commit();
	}
	public BattleLog searchdetail(Race race,User user1,User user2){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from battlelog where raceid=? and battleuserid1=? and battleuserid2=?");
		qry.setParameter(0, race.getRaceid());
		qry.setParameter(1,user1.getUserid());
		qry.setParameter(2,user2.getUserid());
		java.util.List list = qry.list();
		BattleLog result=(BattleLog)list.get(0);
		return result;
	}
	public List<BattleLog> searchbyraceid(int id){
		List<BattleLog> result=new ArrayList<BattleLog>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from battlelog where raceid=?");
		qry.setParameter(0, id);
		java.util.List list = qry.list();
		return result;
	}
	public List<BattleLog> searchbyuserid(User user){
		List<BattleLog> result=new ArrayList<BattleLog>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from battlelog where battleuserid1=? or battleuserid2=?");
		qry.setParameter(0, user.getUserid());
		qry.setParameter(1, user.getUserid());
		java.util.List list = qry.list();
		return result;
	}
}
