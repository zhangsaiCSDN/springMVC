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
		mav.addObject("x", "�貨΢��");
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		// �Զ��Ƶ���keyΪ��stringList
		mav.addObject(list);
		// �Զ��Ƶ���keyΪ��date
		mav.addObject(new Date());
		return mav;
	}
	
	
	/*
	 ���������ķ���ֵ��String����ʱ����ʾ���ص����߼���ͼ����
	 ��ʱ��θ���ͼ���������أ��� ��ʱ����Ҫ���������ķ������һ����ʽ������Model
	����ֻ��Ҫ���������õ���Model���͵ı����м��ɡ�
	
	��ס����������������ķ������ͱ�д����String���ͣ�������ִ������Ƶķ�������Ȼ��ѷ��ص�String���͵Ľ����װΪModelAndView
	*/
	@RequestMapping("save2")
	public String save2(Model model) {
		System.out.println("save2...");
		model.addAttribute("x","������");
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
		// ת����
//		return "g";  
		// �ض���  ע�⣬��Ϊ�ض����ǿͻ�����ת������ͼ���������ڷ������ˣ������ض���ʱ�����Լ��ֶ����ǰ��׺����
		return "redirect:/g.jsp";
	}
	
	
	/*
	 SpringMVC��λ�ȡwebԪ�أ�
	 ֻ�ܻ�ȡ��request��session��response
	*/
	@RequestMapping("save4")
	public String save4(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws Exception {
		request.setAttribute("x", "��ɽ��÷��");
		session.setAttribute("x", "��ɽͯ��");
		request.getServletContext().setAttribute("x", "��������");
		response.sendRedirect("http://www.163.com");
		return "g";
	}
	
	
	
	
	
	
	
	
	
}