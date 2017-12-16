package io.hexaforce.dievas.system.servlet;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;


@Component
public class DievasFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest x = (HttpServletRequest) request;
		String user = "unknown user";
		Principal principal = x.getUserPrincipal();
		if (principal != null && !"".equals(principal.getName())) {
			user = principal.getName();
		}
		
        try {
    		String s = WebUtils.getSessionId(x);
    		MDC.put("user", user + " : " + s.substring(0, s.indexOf(("-"))));
            chain.doFilter(request, response);
        } finally {
            MDC.remove("user");
        }
        
	}

	@Override
	public void destroy() {
		
	}

}
