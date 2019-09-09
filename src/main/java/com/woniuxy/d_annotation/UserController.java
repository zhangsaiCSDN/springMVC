package com.woniuxy.d_annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("user")  
@Controller
public class UserController {
	
	@RequestMapping("save")
	public ModelAndView save() {
		System.out.println("UserController.save()");
		return new ModelAndView("d");
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
