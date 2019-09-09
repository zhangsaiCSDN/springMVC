package com.woniuxy.f_parameter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping("/f1")
	public ModelAndView f1(byte b,short s,int i,long l,float f,double d,boolean bb,char c) {
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(bb);
		System.out.println(c);
		return new ModelAndView("f");
	}
	
	@RequestMapping("/f2")
	public ModelAndView f2(String str) {
		System.out.println(str);
		return new ModelAndView("f");
	}
	
	@RequestMapping("/f3")
	public ModelAndView f3(User user) {
		System.out.println(user);
		return new ModelAndView("f");
	}
	
	
	/*
	 ��Ҫ��Ϊ��ֻҪ��Ϊ�������Ĳ������Ǿ�һ���ܽ������������
	 �������еĿ������Ĳ�������������������������ġ�
	 ���磬���µ�List�������������޷�������������ģ�Ϊ����List�ܽ����������������Ҫ��List����ǰ����@RequestParamע�⡣
	 
	 �����Ҫ���������������ֱ���ڿ���ǰ�����������ʽ�����������ʽ�������ܲ��ˣ�������ʽ����ǰ��@RequestParamע�⡣ 
	*/
	@RequestMapping("/f4")
	public ModelAndView f4(@RequestParam List hobby) {
		System.out.println(hobby);
		System.out.println(hobby.getClass());
		return new ModelAndView("f");
	}
	
	@RequestMapping("/f5")
	public ModelAndView f5(@RequestParam Set hobby) {
		System.out.println(hobby);
		System.out.println(hobby.getClass());
		return new ModelAndView("f");
	}

	/*
	 Map������Ϊ��������ʽ�����������������������ʱ����ʽ����������û�����ƣ�
	*/
	@RequestMapping("/f6")
	public ModelAndView f6(@RequestParam Map map) {
		System.out.println(map);
		System.out.println(map.getClass());
		return new ModelAndView("f");
	}
	
}
