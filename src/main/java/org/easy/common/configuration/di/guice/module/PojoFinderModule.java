package org.easy.common.configuration.di.guice.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.easy.common.persistence.pojo.CorePojo;
import org.easy.settings.persistence.pojo.Bank;

public class PojoFinderModule extends AbstractModule{
	private static final Logger logger = LoggerFactory.getLogger(PojoFinderModule.class);
	@Override
	protected void configure() {
		logger.trace("Guice init");
		bind(CorePojo.class).annotatedWith(Names.named("bankPojo"))
		.to(Bank.class);
		
	}

}
