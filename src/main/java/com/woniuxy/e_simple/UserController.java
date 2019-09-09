package com.woniuxy.e_simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")  
public class UserController {
	
	@RequestMapping("save")
	public ModelAndView save() {
		System.out.println("UserController.save()  eee");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("d");
		mav.addObject("obj", "java!!"); // request.setAttribute("obj", "java!!");
		return mav;
	}
	
	@RequestMapping("delete")
	public ModelAndView delete() {
		System.out.println("UserController.delete()");
		return new ModelAndView("d");
	}
	
	@RequestMapping("update")
	public ModelAndView update() {
		System.out.println("UserController.update()");
		return new ModelAndView("d");
	}
}
