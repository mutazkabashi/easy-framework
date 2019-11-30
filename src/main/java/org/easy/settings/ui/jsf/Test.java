package org.easy.settings.ui.jsf;

import org.easy.common.utils.PropertiesFile;

public class Test {
	
	public static void main(String[] args) {
		final String DILIBRARY = new PropertiesFile()
				.getPrpoertyValueFromClassPathFile("config/application.properties",
						"DILIBRABRY");
		Bank bank = new Bank();
		System.out.println(" "+Test.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		/*System.out.println(" Core Pojo type "+bank.getcP().getClass().getCanonicalName());
		System.out.println(" Core Service Type  "+bank.getcS().getClass().getCanonicalName());*/
	}
	
	

}
