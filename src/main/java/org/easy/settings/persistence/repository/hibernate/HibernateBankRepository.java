package org.easy.settings.persistence.repository.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.easy.common.persistence.pojo.CorePojo;
import org.easy.common.persistence.repository.hibernate.CoreHibernateRepository;
import org.easy.common.persistence.repository.hibernate.util.HibernateUtil;
//import org.easy.settings.bussines.pojo.Country;
import org.easy.settings.persistence.pojo.Bank;
import org.easy.settings.persistence.repository.BankRepository;

/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
public class HibernateBankRepository extends CoreHibernateRepository implements BankRepository {

	private static final Logger logger = getLogger();
	
	public List<CorePojo> selectAll() {
		logger.debug("selectAll() @HibernateBankRepository Start");
		String query = "getAllBanks";
		logger.debug("selectAll() @HibernateBankRepository End return value: {}", super.selectAll(query));
		return super.selectAll(query);
	}
	
	public void save(CorePojo pojo){
		logger.debug("save() @HibernateBankRepository Start");
		try {

			Session session = HibernateUtil.getSession();
			//Transaction trans = session.beginTransaction();

			//Country country = (Country)session.get(Country.class, new Integer(((Bank)pojo).getCountryId()/*((Bank)pojo).getCountry().getId()*/));
            //((Bank)pojo).setCountry(country);
			
			super.save(pojo);
		logger.debug("save() @HibernateBankRepository End");
		} catch (Exception e) {
			e.printStackTrace();
		}
          
	
	}

}
