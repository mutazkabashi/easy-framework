package org.easy.common.configuration.di.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.easy.common.configuration.di.guice.module.PojoFinderModule;

import java.util.List;

public class Graph {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PojoFinderModule());
		Tester tester = injector
				.getInstance(Tester.class);
	}
}