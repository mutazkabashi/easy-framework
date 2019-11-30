package org.easy.common.utils;

import java.util.Collection;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;



//import com.sun.faces.util.CollectionsUtils;

//import com.sun.faces.util.CollectionsUtils;

/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
public class Util {

	//Each logging statement should contain both data and description
	//log.debug("Returning user ids: {}", collect(users, "id"));
	/*
	 * public String printDocument(Document doc, Mode mode) {
2	    log.debug("Entering printDocument(doc={}, mode={})", doc, mode);
3	    String id = //Lengthy printing operation
4	    log.debug("Leaving printDocument(): {}", id);
5	    return id;
6	}
	 */
	public static Collection collect(Collection collection, String propertyName) {
		      return CollectionUtils.collect(collection,
				new BeanToPropertyValueTransformer(propertyName));
	}
	
	/**
	 * Used to get Class Name
	 * @param object
	 * @return Class Name
	 */
	
	public static String getClassName(Object object){
		return object.getClass().getName();
	}

}
