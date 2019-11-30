package org.easy.common.configuration.di.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.easy.common.business.service.CoreService;
import org.easy.settings.bussines.service.bank.ValueDarBankService;

public class ServiceFinderModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(CoreService.class).annotatedWith(Names.named("bankService"))
		.to(ValueDarBankService.class);
		
	}

}
