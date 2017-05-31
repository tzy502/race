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
	public List<BattleTable> load(Race id){
		List<BattleTable> result =new ArrayList<BattleTable>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from BattleTable where raceid=?");
		qry.setParameter(0, id);
		java.util.List list = qry.list();
		result=list;
		session.getTransaction().commit();
		return result;
	}
	public BattleTable search(Race id,User userid){
		BattleTable result=new BattleTable();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from BattleTable where raceid=? and userid=?");
		qry.setParameter(0, id);
		qry.setParameter(1, userid);
		java.util.List list = qry.list();
		result=(BattleTable) list.get(0);
		session.getTransaction().commit();
		return result;
	}
}
