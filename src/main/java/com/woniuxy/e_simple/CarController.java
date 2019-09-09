package com.woniuxy.e_simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("car")  
public class CarController {
	
	@RequestMapping("save")
	public ModelAndView save() {
		System.out.println("CarController.save()");
		return new ModelAndView("d");
	}
	
	@RequestMapping("delete")
	public ModelAndView delete() {
		System.out.println("CarController.delete()");
		return new ModelAndView("d");
	}
	
	@RequestMapping("update")
	public ModelAndView update() {
		System.out.println("CarController.update()");
		return new ModelAndView("d");
	}
}
