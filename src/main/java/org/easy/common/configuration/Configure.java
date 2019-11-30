package org.easy.common.configuration;

import java.util.HashMap;

/**
 * Used To get Application's Settings from Application's Configuration file
 *@author Mutaz Hussein Kabashi
 *
 */
public interface Configure {
	/**
	 * fetch application Type from Configuration File. 
	 * The return value could be (WEB) for Web application 
	 * or (APPLICATION) for Desktop Application
	 * @return Application Type
	 */
	public String getApplicationType();
	
	/**
	 * get DILIBRARY from Application Configuration File.
	 * DILIBRARY could be (SPRING) which means application uses spring framework
	 * or (GUICE) which means it uses GUICE framework
	 * @return
	 */
	public String getDILibrary();
  /**
   * return  Application's settings  (Confuration file values) as a hash Map Object  	
   * @return
   */
	public HashMap<String, String> getApplicationProperties();

}
