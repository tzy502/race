package DAO;

import org.hibernate.Session;

import model.User;
import util.*;

public class UserDAO {
	
	public User Searchuserbyid(String userid){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from User where userid=?");
		qry.setParameter(0, userid);
		java.util.List list = qry.list();
		session.getTransaction().commit();
		if(list.size()==0){
			return null;
		}
		else{
			User result=(User)list.get(0);
			System.out.println(result);
			System.out.println(result.getUsername()+"来自DAO");
			return result;
		}

	}
	public void register(User user){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		System.out.println("from DAO register");
		session.getTransaction().commit();
	}
	public void modifyuser(User user){
//		if(Searchuserbyid(user.getUserid())==null){
//			throw new Exception("�Ҳ���");
//		}
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
	}
	public boolean login(User user){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		System.out.println("from dao login");
		org.hibernate.Query qry = session.createQuery("from User where userid=? and pwd=?");
		qry.setParameter(0, user.getUserid());
		qry.setParameter(1, user.getPwd());
		User loginuser=new User();
		java.util.List list = qry.list();
		session.getTransaction().commit();
		if(list.size()!=0){
			System.out.println("ok");
			return true;			
		}
		else{
			System.out.println("error");
			return false;
		}

	}

}
