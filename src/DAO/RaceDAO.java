package DAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import model.Race;
import util.HibernateUtil;
public class RaceDAO {
	public void addrace(Race race){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(race);
		session.getTransaction().commit();
	}
	public List<Race> load(){
		List<Race> result =new ArrayList<Race>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from race");
		java.util.List list = qry.list();
		result=list;
		return result;
	}
	public Race searchracebyid(int id){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from race where raceid=?");
		qry.setParameter(0, id);
		java.util.List list = qry.list();
		Race result=(Race)list.get(0);
		return result;
	}
	public Race searchracebyname(String name){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from race where racename like ?");
		qry.setParameter(0, name);
		java.util.List list = qry.list();
		Race result=(Race)list.get(0);
		return result;
	}
	public void modifyrace(Race race) throws Exception{
//		if(searchracebyid(race.getRaceid())==null){
//				throw new Exception("查无数据");
//		}
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(race);
		session.getTransaction().commit();
	}
}
