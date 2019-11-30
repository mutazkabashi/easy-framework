package org.easy.common.utils.reflection;

import java.lang.invoke.MethodHandle;
/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */

public interface Reflection {
	
	/**
	 * Used to get a method at runtime using the following parameters 
	 * @param className
	 * @param methodName
	 * @param returnType
	 * @param parameterType
	 * @return
	 */
	public  MethodHandle getMethod(Object ... o);

}
