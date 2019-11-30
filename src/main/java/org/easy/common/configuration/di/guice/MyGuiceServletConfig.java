package org.easy.common.configuration.di.guice;
/*package org.easy.configuration.di.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.ServletModule;
import org.easy.configuration.di.guice.module.PojoFinderModule;
import org.easy.configuration.di.guice.module.ServiceFinderModule;

public class MyGuiceServletConfig implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new Module[] {
				new PojoFinderModule(), new ServiceFinderModule(),
				new ServletModule() });
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}
}
*/