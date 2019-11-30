package org.easy.common.persistence.repository.hibernate.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
public class SessionUtils {
	
	private SessionUtils(){
		
	}
	
	public static  void save(Object o) {
		Session session = HibernateUtil.getSession();

		Transaction trans = session.beginTransaction();
		session.save( o );
		trans.commit();
		session.close();
	}

	public Object select(Object o, int id) {
		Session session = HibernateUtil.getSession();
		session.close();
		return session.get( o.getClass(), new Integer( id ) );

	}

}
