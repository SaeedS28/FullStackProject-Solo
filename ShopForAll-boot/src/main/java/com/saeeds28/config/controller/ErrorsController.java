package com.saeeds28.config.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorsController implements ErrorController {

	private static final String PATH= "/error";
	
	@RequestMapping(method = RequestMethod.GET, path = PATH)
	public ModelAndView handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			Integer code = Integer.valueOf(status.toString());
			
			if(code == HttpStatus.NOT_FOUND.value()) {
				return new ModelAndView("Status404");
			}
			else if(code == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return new ModelAndView("Status500");
			}
		}
		return null;
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
