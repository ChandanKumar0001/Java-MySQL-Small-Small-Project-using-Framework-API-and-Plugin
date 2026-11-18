package com.jsp.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.jsp.hibernate.entity.Actor;



public class App 
{
	public static void main( String[] args )
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Actor.class);

		SessionFactory sf= cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tran=ss.beginTransaction();
		
		Criteria criteria = ss.createCriteria(Actor.class);
//		criteria.add(Restrictions.eq("actorId", 102));
//		criteria.add(Restrictions.gt("actorId", 102));
//		criteria.add(Restrictions.lt("actorId", 102));
//		criteria.add(Restrictions.like("actorName", "Pawan Kalyayan"));
//		criteria.add(Restrictions.between("actorId", 101,104));
		

//		List<Actor> actors = criteria.list();
//		for(Actor actor : actors) {
//			System.out.println(actor);
//		}
		
		//SELECT
		criteria.setProjection(Projections.property("actorName"));
		List<String> actors = criteria.list();
		for(String actor : actors) {
			System.out.println(actor);
		}
		
		
		tran.commit();
		ss.close();
		sf.close();

	}
}
