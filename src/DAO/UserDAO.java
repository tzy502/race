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
		User result=(User)list.get(0);
		System.out.println(result);
		System.out.println(result.getUsername()+"来自DAO");
		session.getTransaction().commit();
		return result;
	}
	public void register(User user) throws Exception{
//		if(user.getUserid()==null){
//			throw new Exception("�ʺŲ���Ϊ��");
//		}
//		if(user.getPwd()==null){
//			throw new Exception("���벻��Ϊ��");
//		}
//		if(user.getUsername()==null){
//			throw new Exception("��������Ϊ��");
//		}
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	public void modifypwd(User olduser,User newuser)throws Exception {
//		if(!login(olduser)){
//			throw new Exception("�������");
//		}
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(newuser);
		session.getTransaction().commit();
	}
	public void modifyuser(User user)throws Exception {
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
