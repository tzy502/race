package DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.*;
import util.HibernateUtil;

public class BattleTableDAO {
	public void add(BattleTable bt){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(bt);
		session.getTransaction().commit();
	}
	public void modify(BattleTable bt){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(bt);
		session.getTransaction().commit();
	}
	public List<BattleTable> loadallplay(int raceid){
		List<BattleTable> result =new ArrayList<BattleTable>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from BattleTable where raceid=?");
		qry.setParameter(0, raceid);
		java.util.List list = qry.list();
		result=list;
		session.getTransaction().commit();
		return result;
	}
	public BattleTable search(int raceid,String userid){
		BattleTable result=new BattleTable();
		result=null;
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from BattleTable where raceid=? and userid=?");
		qry.setParameter(0, raceid);
		qry.setParameter(1, userid);
		java.util.List list = qry.list();
		result=(BattleTable) list.get(0);
		session.getTransaction().commit();
		return result;
	}
	public List<BattleTable> loadsigner(int raceid){
		List<BattleTable> result =new ArrayList<BattleTable>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from BattleTable where lose=0 and raceid=? order by 'key'");
		qry.setParameter(0, raceid);
		System.out.println("From btd");
		result = qry.list();
		System.out.println("From btd 2");
		session.getTransaction().commit();
		
		return result;
	}
}
