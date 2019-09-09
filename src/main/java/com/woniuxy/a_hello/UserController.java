package com.woniuxy.a_hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {

	public UserController() {
		System.out.println("UserController.UserController()");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("UserController.handleRequest() ......");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");  // 
		
		return mav;
	}

}
