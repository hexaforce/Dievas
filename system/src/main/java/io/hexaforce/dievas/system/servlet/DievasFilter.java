package io.hexaforce.dievas.system.servlet;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

@Component
public class DievasFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String sessionId = WebUtils.getSessionId(httpRequest);
		
		String user = "unknown user";
		Principal principal = httpRequest.getUserPrincipal();
		if (principal != null && !"".equals(principal.getName())) {
			user = principal.getName();
		}

        try {
        	
        	if ("/Dievas".equals(httpRequest.getRequestURI())) {
        		MDC.put("user", user + " : " + sessionId + " : " + httpRequest.getHeader("User-Agent"));
        	} else {
        		MDC.put("user", user + " : " + sessionId.substring(0, sessionId.indexOf(("-"))));
        	}
        	
    		filterChain.doFilter(request, response);
    		
        } finally {
            MDC.remove("user");
        }
        
	}

}
