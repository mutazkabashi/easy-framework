package org.easy.common.configuration.di;

import java.lang.invoke.MethodHandles;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;

import com.google.inject.Injector;

/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */

public class EasyWebInjector implements EasyInjector{
	private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static Injector guiceInjector;
	private static AutowireCapableBeanFactory springInjector;
	
	public Injector getGuiceInjector() {
		logger.debug("getGuiceInjector() @InjectorUtil Start");
		if (guiceInjector == null) {
			logger.debug("init guiceInjector variable @getGuiceInjector() @InjectorUtil ");
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();
			guiceInjector = (Injector) servletContext
					.getAttribute(Injector.class.getName());
		}
		logger.debug("getGuiceInjector() @InjectorUtil End");
		return guiceInjector;
	}

	public AutowireCapableBeanFactory getSpringInjector() {
		logger.debug("getSpringInjector() @InjectorUtil Start");
		if (springInjector == null) {
			logger.debug("init springInjector variable @getSpringInjector() @InjectorUtil ");
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();
			WebApplicationContext injector = (WebApplicationContext) servletContext
					.getAttribute("SPRINGINJECTOR");
			springInjector = injector.getAutowireCapableBeanFactory();
		}
		logger.debug("getSpringInjector() @InjectorUtil End");
		return springInjector;
	}

}
