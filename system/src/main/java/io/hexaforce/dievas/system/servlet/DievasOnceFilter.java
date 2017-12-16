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

public class DievasOnceFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		HttpServletRequest x = (HttpServletRequest) request;
		String user = "unknown user";
		Principal principal = x.getUserPrincipal();
		if (principal != null && !"".equals(principal.getName())) {
			user = principal.getName();
		}

        try {
    		MDC.put("user", user + " : " + WebUtils.getSessionId(x) + " : " + x.getHeader("User-Agent"));
    		filterChain.doFilter(request, response);
        } finally {
            MDC.remove("user");
        }
        
	}

}
