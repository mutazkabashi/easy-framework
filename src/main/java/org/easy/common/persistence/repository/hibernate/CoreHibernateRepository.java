package org.easy.common.persistence.repository.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.easy.common.Core;
import org.easy.common.persistence.pojo.CorePojo;
import org.easy.common.persistence.repository.CoreRepository;
import org.easy.common.persistence.repository.hibernate.util.HibernateUtil;
import org.easy.common.persistence.repository.hibernate.util.HqlUtils;

/**
 * A hibernate  super class repository that handles the common operations for all Data Access Objects.
 * 
 * @author Mutaz Hussein Kabashi
 *
 */

public class CoreHibernateRepository extends Core implements CoreRepository {

	private static final Logger logger = getLogger();
	
	public void save(CorePojo pojo) {
		logger.debug("save() @CoreHibernateRepository Start");
		try {
           Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();

			session.save(pojo);

			trans.commit();
			session.close();
			logger.debug("save() @CoreHibernateRepository End");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(CorePojo pojo){
		logger.debug("update() @CoreHibernateRepository Start");
		try {

			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();

			session.update(pojo);

			trans.commit();
			session.close();
		logger.debug("update() @CoreHibernateRepository End");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(CorePojo pojo){
		logger.debug("delete() @CoreHibernateRepository Start");
		try {

			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();

			session.delete(pojo);

			trans.commit();
			session.close();
		logger.debug("delete() @CoreHibernateRepository End");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<CorePojo> selectAll(Object  o){
		logger.debug("selectAll() @CoreHibernateRepository Start");
		 List<CorePojo> reuslt = new ArrayList<CorePojo>();
		try {
           
			Session session = HibernateUtil.getSession();
			//Transaction trans = session.beginTransaction();

			reuslt = (List<CorePojo>) HqlUtils.hqlNamedQuery(session, o.toString());

			//trans.commit();
			session.close();
		logger.debug("selectAll() @CoreHibernateRepository End");
			//return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return reuslt;
		}
		
	}

	@Override
	public List<CorePojo> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CorePojo getById(Object o){
		logger.debug("getById() @CoreHibernateRepository Start");
		 CorePojo reuslt = new CorePojo();
			try {
	           
				Session session = HibernateUtil.getSession();
				//Transaction trans = session.beginTransaction();

				reuslt = (CorePojo) HqlUtils.hqlSelect(session, o.toString());

				//trans.commit();
				session.close();
		logger.debug("getById() @CoreHibernateRepository End");
				//return result;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				return reuslt;
			}

		
	}

}
