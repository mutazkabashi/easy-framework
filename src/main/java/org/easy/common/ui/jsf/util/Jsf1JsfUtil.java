package org.easy.common.ui.jsf.util;

import javax.faces.context.FacesContext;

/**
 * JSF Utility Class
 * @author Mutaz Hussein Kabashi
 *
 */

public class Jsf1JsfUtil implements JsfUtil {
	
	
	
	public  Object getApplicationScopedManagdBean(Object managedBeanName){
		Object managedBean =  FacesContext.getCurrentInstance().
				getExternalContext().getApplicationMap().get(managedBeanName.toString());
		return managedBean;
	}
	
	
	
	public  Object getSessionScopedManagedBean(Object managedBeanName){
		Object managedBean =  FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap().get(managedBeanName.toString());
		return managedBean;
	}
	
	
	
	public  Object getRequestScopedManagedBean(Object managedBeanName){
		Object managedBean =  FacesContext.getCurrentInstance().
				getExternalContext().getRequestMap().get(managedBeanName.toString());
		return managedBean;
	}

}
