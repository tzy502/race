package DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.*;
import util.HibernateUtil;
public class BattleManagerDAO {
	public void add(BattleManager bm){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(bm);
		session.getTransaction().commit();
	}
	public void modify(BattleManager bm){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(bm);
		session.getTransaction().commit();
	}
	public List<BattleManager> searchallmanager(int raceid){
		List<BattleManager> result =new ArrayList<BattleManager>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from BattleManager where raceid=?");
		qry.setParameter(0, raceid);
		java.util.List list = qry.list();
		result=list;
		session.getTransaction().commit();
		return result;
	}
	public List<BattleManager> searchallrace(String userid){
		List<BattleManager> result =new ArrayList<BattleManager>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from BattleManager where userid=?");
		qry.setParameter(0, userid);
		java.util.List list = qry.list();
		result=list;
		session.getTransaction().commit();
		return result;
	}
	public BattleManager searchdetail(String userid,int raceid){
		BattleManager result =new BattleManager();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from BattleManager where userid=? and raceid=?");
		qry.setParameter(0, userid);
		qry.setParameter(0, raceid);
		java.util.List list = qry.list();
		result=(BattleManager) list.get(0);
		session.getTransaction().commit();
		return result;
	}
	public void del(BattleManager bm){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(bm);
		session.getTransaction().commit();
	}
}
