package io.hexaforce.dievas.system.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

public class DievasRequestListener implements ServletRequestListener, ServletContextAware, ApplicationContextAware {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {

	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
	}

}
