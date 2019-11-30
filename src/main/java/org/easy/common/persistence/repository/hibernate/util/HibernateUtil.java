package org.easy.common.persistence.repository.hibernate.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

//import test.*;
/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static String config = "config/hibernate.cfg.xml";
	static {
		try {
			sessionFactory = new Configuration().configure(config)
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Log exception!
			System.out.println("===" + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

}
