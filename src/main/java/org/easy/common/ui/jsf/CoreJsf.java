package org.easy.common.ui.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Injector;
import org.easy.common.Core;
import org.easy.common.business.service.CoreService;
import org.easy.common.persistence.pojo.CorePojo;

import java.util.ResourceBundle;

/**
 * The Super Class of JSF Managed Bean classes ,which contains common variables
 * and methods
 * 
 * @author mutaz Hussein Kabashi
 * 
 */
public abstract class CoreJsf extends Core implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1350413821947664741L;
	private static final Logger logger = getLogger();

	//private Injector injector;  
	//TODO create Injector interface (Guice,Spring ,...etc) should implement it
	
	private CorePojo cP;

	private CoreService cS;
	private String msg;
	private CorePojo currentRow;
	private List<CorePojo> dataTableList;
	private List<SelectItem> dropDownMenu;
	protected ResourceBundle msgPropsFile = ResourceBundle
			.getBundle("properties/messages/messages"/*
													 * GlobalVarManager.
													 * getLocaleInformation
													 * ().getMsgBundle()
													 */);

	public CoreJsf() {
		init();
		getDataTableData();
	}

	/**
	 * init Managed Bean variables
	 */
	@PostConstruct
	public void init() {
		logger.debug("Init() @CoreJsf Start");
		 //getInjector().injectMembers(this);
		injectMembers();
		destroy();
		dataTableList = new ArrayList<CorePojo>();
		logger.debug("Init() @CoreJsf End");

	}

	/**
	 * This method is used to init/destory cP and cS variables. this method is
	 * called during the init of JSF Page
	 */
	public abstract void destroy();

	/**
	 * add a Pojo to a system data base
	 */
	public void save() {
		logger.debug("save() @CoreJsf Start");
		System.out.println("cp ===" + cP.toString());
		cS.add(cP);
		getDataTableData();
		destroy();
		logger.debug("save() @CoreJsf End");
		// setMsg("company has been added succesfully");

		// return "addcompany";

	}

	/**
	 * Clean JSF Screen
	 */
	public void cancel() {
		logger.debug("cancel() @CoreJsf Start");
		destroy();
		setMsg("");
		logger.debug("cancel() @CoreJsf End");
		// return "addcompany";
	}

	/**
	 * remove a selected pojo from the data base
	 */
	public void delete() {
		logger.debug("delete() @CoreJsf Start");
		cS.delete(cP);
		/*
		 * setMsg("company has been added succesfully");
		 */
		getDataTableData();
		destroy();
		logger.debug("delete() @CoreJsf End");

		// return "addcompany";

	}

	/**
	 * update selected pojo
	 */

	public void update() {
		logger.debug("update() @CoreJsf Start");
		cS.update(cP);
		/*
		 * setMsg("company has been added succesfully");
		 */

		getDataTableData();
		destroy();
		logger.debug("update() @CoreJsf End");

		// return "addcompany";

	}

	public void getDataTableData() {
		logger.debug("getDataTableData() @CoreJsf Start");
		dataTableList = cS.getAll();
		System.out.println("list size====" + getDataTableList().size());
		logger.debug("getDataTableData() @CoreJsf End");
	}

	public void currentRow() {
		logger.debug("getDataTableData() @CoreJsf Start");
		cP = getCurrentRow();
		logger.debug("getDataTableData() @CoreJsf End");

	}

	public List<SelectItem> gDropDownMenuConvertor(CoreService cs) {
		// logger.debug("dropDownMenuConvertor() @CoJsf Start");
		logger.debug(
				"gDropDownMenuConvertor() (CoreService={}) @CoreJsf Start", cs);
		List<SelectItem> resultList = new ArrayList<SelectItem>();
		List<CorePojo> TempList = cs.getAll();
		for (CorePojo currentPojo : TempList) {
			resultList.add(new SelectItem(currentPojo.getId(), currentPojo
					.getItemLabel()));
			// logger.debug("item Label "+currentPojo.getItemLabel());
		}
		logger.debug("gDropDownMenuConvertor() @CoreJsf End resultList Size: {}", resultList.size());
		return resultList;
	}

	public CorePojo getcP() {
		return cP;
	}

	public void setcP(CorePojo cP) {
		this.cP = cP;
	}

	public CoreService getcS() {
		return cS;
	}

	public void setcS(CoreService cS) {
		this.cS = cS;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CorePojo getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(CorePojo currentRow) {
		this.currentRow = currentRow;
	}

	public List<?> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<CorePojo> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public List<SelectItem> getDropDownMenu() {
		return dropDownMenu;
	}

	public void setDropDownMenu(List<SelectItem> dropDownMenu) {
		this.dropDownMenu = dropDownMenu;
	}
	
	/*public Injector getInjector() {
	    if(injector == null) {
	      ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().
	                                       getExternalContext().getContext();
	      injector = (Injector)servletContext.getAttribute(Injector.class.getName());  
	    }
	    return injector;
	  }
	  public void setInjector(Injector injector) {
	    this.injector = injector;
	  }*/
	  
	 

}
