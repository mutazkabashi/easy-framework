package org.easy.common.configuration;

import java.util.HashMap;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

/**
 * Configue Implementaion Using ApacheCommonConfiguration library
 * to read Application's Configuration File
 * @author Mutaz Hussein Kabashi
 * 
 */
public class ApacheCommonConfigure implements Configure {

	private String applicationFileName;
	private XMLConfiguration config;
	private HashMap<String, String> applicationProperties;

	/**
	 * Deafult Constructor, if a client dosen't specify a  config file ,
	 * the Framework will  assume that the (application.xml) is the application 
	 * Configuration file
	 */
	public ApacheCommonConfigure() {
		applicationFileName = "application.xml"; 
		// TODO should We call ApacheCommonConfigure(String applicationFileName) [Is it good for testing]
		init();
	}
	
	/**
	 * Client have to specify the application's configuration file
	 * if not , the framework will use the (application.xml) as an application's
	 * configuration file  
	 * @param applicationFileName application 
	 */

	public ApacheCommonConfigure(String applicationFileName) {
		this.applicationFileName = applicationFileName;
		init();
	}

	public void init() {
		try {
			config = new XMLConfiguration(applicationFileName);

			// DILibrary
			applicationProperties.put("DILibrary",
					config.getString("dilibrary"));

			// ApplicationType
			applicationProperties.put("applicationtype",
					config.getString("applicationtype"));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getApplicationType() {
		return applicationProperties.get("applicationtype");
	}

	@Override
	public String getDILibrary() {
		return applicationProperties.get("DILibrary");
	}
	@Override
	public HashMap<String, String> getApplicationProperties() {
		return applicationProperties;
	}



}
