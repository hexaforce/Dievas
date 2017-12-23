package io.hexaforce.dievas.system.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import lombok.extern.slf4j.Slf4j;

/**
 * @author T.Tantaka
 *
 */

@Slf4j
//@Component
//@WebListener
public class DievasRequestListener implements ServletRequestListener, ServletContextAware {

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		//HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.addListener(this);
	}

}
