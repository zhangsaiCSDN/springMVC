package com.woniuxy.g_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("save")
	public ModelAndView save() {
		System.out.println("save...");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("g");
		mav.addObject("x", "凌波微步");
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		// 自动推导出key为：stringList
		mav.addObject(list);
		// 自动推导出key为：date
		mav.addObject(new Date());
		return mav;
	}
	
	
	/*
	 当控制器的返回值是String类型时，表示返回的是逻辑视图名。
	 此时如何给视图传递数据呢？？ 此时就需要给控制器的方法添加一个形式参数：Model
	我们只需要把数据设置到该Model类型的变量中即可。
	
	记住，就算控制器方法的返回类型被写成了String类型，适配器执行完控制的方法后，仍然会把返回的String类型的结果封装为ModelAndView
	*/
	@RequestMapping("save2")
	public String save2(Model model) {
		System.out.println("save2...");
		model.addAttribute("x","六脉神剑");
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		model.addAttribute(list);
		model.addAttribute(new Date());
		return "g";  // /g.jsp
	}
	
	
	@RequestMapping("save3")
	public String save3() {
		System.out.println("save3()");
		// 转发：
//		return "g";  
		// 重定向：  注意，因为重定向是客户端跳转，而视图解析器又在服务器端，所以重定向时必须自己手动添加前后缀！！
		return "redirect:/g.jsp";
	}
	
	
	/*
	 SpringMVC如何获取web元素：
	 只能获取：request、session、response
	*/
	@RequestMapping("save4")
	public String save4(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws Exception {
		request.setAttribute("x", "天山折梅手");
		session.setAttribute("x", "天山童姥");
		request.getServletContext().setAttribute("x", "东方不败");
		response.sendRedirect("http://www.163.com");
		return "g";
	}
	
	
	
	
	
	
	
	
	
}