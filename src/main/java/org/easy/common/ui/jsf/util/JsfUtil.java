package org.easy.common.ui.jsf.util;

import javax.faces.context.FacesContext;

/**
 * 
 *@author Mutaz Hussein Kabashi
 *
 */
public interface JsfUtil {

	/**
	 * used to get Application Scoped Managed Bean
	 * 
	 * @param managedBeanName
	 * @return
	 */
	public Object getApplicationScopedManagdBean(Object managedBeanName);

	/**
	 * used to get Session Scoped Managed Bean
	 * 
	 * @param managedBeanName
	 * @return
	 */
	public Object getSessionScopedManagedBean(Object managedBeanName);

	/**
	 * used to get Request Scoped Managed Bean
	 * 
	 * @param managedBeanName
	 * @return
	 */
	public Object getRequestScopedManagedBean(Object managedBeanName);
}
