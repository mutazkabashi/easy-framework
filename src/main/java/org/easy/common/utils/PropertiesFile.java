package org.easy.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.easy.settings.ui.jsf.Test;

/**
 * 
 * @author  Mutaz Hussein Kabbashi
 *
 */
public class PropertiesFile {
	
	/**
	 * This method Used to get a property value from a properties file
	 * @param fileName
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public String getPrpoertyValueFromClassPathFile(String fileName,String key) {
		
		Properties props = new Properties();
		String value = "";
		try{
		FileInputStream in = new FileInputStream(PropertiesFile.class.getProtectionDomain().getCodeSource().getLocation().getPath()+fileName);
		//Properties props = new Properties();
		props.load(in);
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			System.out.println("key "+keys.nextElement()+" "+props.getProperty(key));
		}
		value = props.getProperty(key);
		in.close();

		/*FileOutputStream out = new FileOutputStream(fileName);
		value = props.getProperty(key);
		props.store(out, null);
		out.close();*/
		
		}catch (Exception ex) {
    		ex.printStackTrace();
        }finally{
        	return value;
        }
	}
	
	/**
	 * This method Used to update a property value in a properties file
	 * @param fileName properties file name
	 * @param key      property key
	 * @param value    property new value
	 * 
	 * 
	 */

	public  void updateProperty(String fileName,String key,String value) throws FileNotFoundException,IOException {
		
			FileInputStream in = new FileInputStream(fileName);
			Properties props = new Properties();
			props.load(in);
			in.close();

			FileOutputStream out = new FileOutputStream(fileName);
			props.setProperty(key, value);
			props.store(out, null);
			out.close();
		
	}
	
	public  Properties loadFromFile(String file) throws IOException {
        Properties properties = new Properties();
        FileInputStream stream = new FileInputStream(file);
        try {
            properties.load(stream);
        } finally {
            stream.close();
        }
        return properties;
    }

}
