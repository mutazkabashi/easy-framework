package org.easy.settings.ui.jsf;

import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.easy.common.business.service.CoreService;
import org.easy.common.persistence.pojo.CorePojo;
import org.easy.common.ui.jsf.CoreJsf;
import org.easy.common.utils.Util;

import org.easy.settings.bussines.service.bank.ValueDarBankService;


/**
 * Bank Managed Bean class used to add, update, delete Bank(ies) to/from System
 * Data Base
 * 
 * @author Mutaz Hussein Kabashi
 * 
 */
@ManagedBean(name = "bank")
@SessionScoped
public class Bank extends CoreJsf {

	/**
	 * 
	 */
	private static final long serialVersionUID = -92003400278788934L;
	private static final Logger logger = getLogger();//LoggerFactory.getLogger(Bank.class);
	List<CorePojo> TempList;// = new LogesticCountryService().getAll();
    
	public Bank() {
		super();
		logger.debug("Constructor @BankJsf End");

	}
    //@Inject
	public void destroy() {
    	logger.debug("destroy() @BankJsf Start1");
		/*setcP(new org.easy.bussines.pojo.settings.Bank());
		setcS(new ValueDarBankService());*/ 
		// TODO Guice
		logger.trace("Guice Core Pojo name {} ,Guice Core Service Name {} ",getcP(),getcS());
		logger.trace("Core Pojo name {} , Core Service Name {} ",Util.getClassName(getcP()),Util.getClassName(getcS()));
		logger.info("CorePojo and Core Service init  Succefully");
		// setDropDownMenu(new LogesticCountryService().getAll());
		setDropDownMenu(new ArrayList<SelectItem>());
		//dropDownMenuConvertor();
		logger.debug("destroy() @BankJsf End");

	}

	/*public void dropDownMenuConvertor() {
		logger.debug("dropDownMenuConvertor() @BankJsf Start");
		TempList = new ValueDarCountryService().getAll();
		for (CorePojo currentPojo : TempList) {
			getDropDownMenu()
					.add(new SelectItem(
							currentPojo.getId(),
							((org.easy.settings.bussines.pojo.Country) currentPojo)
									.getCountryEnglishName()));
			logger.debug("Country Name "+((Country)currentPojo).getCountryEnglishName());
		}
		logger.info("Countries Drop Down Menu created Succefully");
		logger.debug("dropDownMenuConvertor() @BankJsf End");
	}*/

	public String New() {
		logger.debug("New() @BankJsf Start");
		super.cancel();
		logger.debug("New() @BankJsf End return value: '{}'", "addbank");
		return "addbank";
	}

	public String saveBank() {
		logger.debug("saveBank() @BankJsf Start");
		/*System.out.println("Country"
				+ ((org.easy.settings.bussines.pojo.Bank) getcP()).getCountry()
						.toString());*/
		super.save();
		//logger.info("The {} Bank has been added succefully",((org.easy.bussines.pojo.settings.Bank)getcP()).getName());
		// cS.addBank(cP);
		setMsg("bank has been added succesfully");
		logger.debug("saveBank() @BankJsf End return value: '{}'", "addbank");
		return "addbank";
	}

	public String updateBank() {
		logger.debug("updateBank() @BankJsf Start");
		super.update();
		//logger.info("The {} Bank has been updated succefully",((org.easy.bussines.pojo.settings.Bank)getcP()).getName());
		setMsg("bank has been updated succesfully");
		logger.debug("updateBank() @BankJsf End return value: '{}'", "updatebank");
		return "updatebank";
	}

	public String deleteBank() {
		logger.debug("deleteBank() @BankJsf Start");
		super.delete();
		logger.info("The {} Bank has been deleted succefully",((org.easy.settings.persistence.pojo.Bank)getcP()).getName());
		setMsg("bank has been deleted succesfully");
		logger.debug("deleteBank() @BankJsf End return value: '{}'", "deletebank");
		return "deletebank";

	}

	public String editBankToUpdate() {
		logger.debug("editBankToUpdate() @BankJsf Start");
		currentRow();
		logger.debug("editBankToUpdate() @BankJsf End return value: '{}'", "updatebank");
		return "updatebank";
	}

	public String editBankToDelete() {
		logger.debug("editBankToDelete() @BankJsf Start");
		currentRow();
		logger.debug("editBankToDelete() @BankJsf End return value: '{}'", "deletebank");
		return "deletebank";
	}
	
	@Inject
	public void setcP(@Named("bankPojo")CorePojo cP) {
		super.setcP(cP);
	}

	
    @Inject
	public void setcS(@Named("bankService")CoreService cS) {
    	super.setcS(cS);
	}
    
    
}