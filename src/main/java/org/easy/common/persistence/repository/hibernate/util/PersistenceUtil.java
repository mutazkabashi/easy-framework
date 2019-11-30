package org.easy.common.persistence.repository.hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
public class PersistenceUtil {

	private static final EntityManagerFactory emf;
    static {
        try {
        	 emf = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager()
            throws HibernateException {
        return emf.createEntityManager();
    }
}
