package org.easy.common;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.easy.common.configuration.ApacheCommonConfigure;
import org.easy.common.configuration.Configure;
import org.easy.common.configuration.di.EasyInjector;
import org.easy.common.configuration.di.EasySwingInjector;
import org.easy.common.configuration.di.EasyWebInjector;

/**
 * 
 * @author Mutaz Hussein Kabashi
 *
 */
public class Core {

	private static final Logger logger = getLogger();
	private static final Configure configure;
	private static final EasyInjector injector;
	private static final String DILIBRARY;

	static {
		configure = new ApacheCommonConfigure();
		DILIBRARY = configure.getDILibrary();
		if (configure.getApplicationType().equalsIgnoreCase("WEB")) {
			injector = new EasyWebInjector();
		} else {
			injector = new EasySwingInjector();
		}
	}

	public static Logger getLogger() {
		return LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	}

	public void injectMembers() {
		logger.debug("injectMembers() @Core Start");
		if (DILIBRARY.equalsIgnoreCase("SPRING")) {
			logger.debug("Inject using SpringInjector injectMembers() @Core ");
			injector.getSpringInjector().autowireBean(this);
		} else if (DILIBRARY.equalsIgnoreCase("Guice")) {
			logger.debug("Inject using GuiceInjector injectMembers() @Core");
			injector.getGuiceInjector().injectMembers(this);
		}
		logger.debug("injectMembers() @Core End");

	}
}
