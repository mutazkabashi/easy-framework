package org.easy.common.configuration.di;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import com.google.inject.Injector;
/**
 * Framework Injector which provides Injector to a caller depends on the caller needs
 * @author Mutaz Hussein Kabashi
 *
 */
public interface EasyInjector {

	public Injector getGuiceInjector();

	public AutowireCapableBeanFactory getSpringInjector();

}
