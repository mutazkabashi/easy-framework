package org.easy.common.utils.reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;



/**
 * 
 * @author mutaz
 *
 */

public class Jdk7Reflection implements Reflection {
	
	
	public  MethodHandle getMethod(Object ...o/*Class className,String methodName,Class returnType,Class parameterType*/){
		Class className = (Class) o[0] ;
		String methodName = o[1].toString();
		Class returnType = (Class) o[2];
		Class parameterType = (Class) o[3];
		MethodHandle mh = null;
		MethodType desc = MethodType.methodType(returnType, parameterType);
		try {
			mh = MethodHandles.lookup().findVirtual(className, methodName, desc);
		} catch (NoSuchMethodException | IllegalAccessException e) {
			throw (AssertionError) new AssertionError().initCause(e);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mh;
	}

}
