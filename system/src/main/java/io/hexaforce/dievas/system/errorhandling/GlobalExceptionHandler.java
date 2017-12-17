package io.hexaforce.dievas.system.errorhandling;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 例外処理
 * 
 * @author T.Tantaka
 *
 */
@Slf4j
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			Exception ex) {
		
		if (ex instanceof JpaSystemException) {
			
			response.reset();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			
			ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
            model.addObject("HttpStatus", HttpStatus.INTERNAL_SERVER_ERROR.value());
            model.addObject("message", ex.getMessage());
            return model;
		}

		log.error("GlobalExceptionHandler");
		log.error(ex.getLocalizedMessage());
		ex.printStackTrace();
        return new ModelAndView();
	}

}
