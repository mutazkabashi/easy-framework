package org.easy.settings.bussines.service.bank;

import java.util.List;

import org.easy.common.persistence.pojo.CorePojo;
import org.easy.common.persistence.repository.CoreRepository;
import org.easy.settings.persistence.repository.hibernate.HibernateBankRepository;

/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
public class ValueDarBankService implements BankService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3659278788392011249L;
	CoreRepository cr;
	
	public ValueDarBankService(){
		 cr = new HibernateBankRepository(); // TODO Guice
	}
	

	@Override
	public String add(CorePojo pojo) {
		try{
		System.out.println("addBank()@LogesticBankService");
		cr.save(pojo);
		return "Bank has been added Successfully";
		}catch (Exception e) {
			e.printStackTrace();
			return "Problem";
		}
	}

	@Override
	public String delete(CorePojo pojo) {
		cr.delete(pojo);
		return "Bank has been deleted Successfully";
	}

	@Override
	public String update(CorePojo pojo) {
		cr.update(pojo);
		return "Bank has been updated Successfully";
		
	}

	@Override
	public String get(CorePojo pojo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<CorePojo> getAll() {
		
		return cr.selectAll();
		
	}


	@Override
	public CorePojo getById(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
