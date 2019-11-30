package org.easy.common.configuration.di.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.easy.common.configuration.di.guice.module.PojoFinderModule;
import org.easy.common.configuration.di.guice.module.ServiceFinderModule;

public class GuiceModuleListener implements ServletContextListener {

  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    ServletContext servletContext = servletContextEvent.getServletContext();
    servletContext.removeAttribute(Injector.class.getName());
  }

  public void contextInitialized(ServletContextEvent servletContextEvent) {
    Injector injector = Guice.createInjector(new  PojoFinderModule(),new ServiceFinderModule());
    ServletContext servletContext = servletContextEvent.getServletContext();
    servletContext.setAttribute(Injector.class.getName(), injector);
  }
}    
