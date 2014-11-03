package it.seda.security.cas.errors.controller;

import java.lang.reflect.Constructor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionsController {
	
	
	@RequestMapping(value="login/exceptions/{exception}/{message}", method = RequestMethod.GET)
	public void exceptionHandler(@PathVariable String exception,@PathVariable String message,ModelMap model,HttpServletRequest request) throws Exception {
		Class<?> clazz = Class.forName(exception);
		Constructor<?> ctor = clazz.getConstructor(String.class);
		Exception exc = (Exception) ctor.newInstance(new Object[] { message });
		throw exc;
	}
	
	
}
