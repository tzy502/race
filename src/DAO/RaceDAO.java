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
		org.hibernate.Query qry = session.createQuery("from Race");

		System.out.println("1");
		result = qry.list();
		System.out.println("2");
		session.getTransaction().commit();
		
		return result;
	}
	public List<Race> loadsigner(int raceid){
		List<Race> result =new ArrayList<Race>();
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from Race where lose=0 and raceid=? orderby key");
		qry.setParameter(0, raceid);
		System.out.println("1");
		result = qry.list();
		System.out.println("2");
		session.getTransaction().commit();
		
		return result;
	}
	public Race searchracebyid(int id){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from Race where raceid=?");
		qry.setParameter(0, id);
		java.util.List list = qry.list();
		Race result=(Race)list.get(0);
		session.getTransaction().commit();
		return result;
	}
	public Race searchracebyname(String name){
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("from Race where racename like ?");
		qry.setParameter(0, name);
		java.util.List list = qry.list();
		Race result=(Race)list.get(0);
		session.getTransaction().commit();
		return result;
	}
	public void modifyrace(Race race) throws Exception{
//		if(searchracebyid(race.getRaceid())==null){
//				throw new Exception("��������");
//		}
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(race);
		session.getTransaction().commit();
	}
	public int searchidbyname(String racename){
		Object result;
		HibernateUtil.getSessionFactory().getCurrentSession();
		Session session =    HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		org.hibernate.Query qry = session.createQuery("Select max(raceid) from Race where racename like ?");
		qry.setParameter(0, racename);
		result=(int) qry.list().get(0);
		session.getTransaction().commit();
		return (int)result;
	}
}
