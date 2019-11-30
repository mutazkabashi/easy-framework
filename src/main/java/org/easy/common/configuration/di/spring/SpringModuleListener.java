package org.easy.common.configuration.di.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringModuleListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute("SPRINGINJECTOR");
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {

		ServletContext ctx = servletContextEvent.getServletContext();
		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext(ctx);
		ctx.setAttribute("SPRINGINJECTOR", springContext);
	}
}
