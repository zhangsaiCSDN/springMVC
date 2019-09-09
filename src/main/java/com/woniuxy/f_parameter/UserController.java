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
	 不要以为，只要作为控制器的参数，那就一定能接受请求参数！
	 不是所有的控制器的参数，都能天生接受请求参数的。
	 比如，以下的List参数，本来是无法接受请求参数的，为了让List能接受请求参数，还需要在List参数前加上@RequestParam注解。
	 
	 如果想要接受请求参数，就直接在控制前方法上添加形式参数，如果形式参数接受不了，就在形式参数前加@RequestParam注解。 
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
	 Map集合作为方法的形式参数，用来接受请求参数的时候，形式参数的名字没有限制！
	*/
	@RequestMapping("/f6")
	public ModelAndView f6(@RequestParam Map map) {
		System.out.println(map);
		System.out.println(map.getClass());
		return new ModelAndView("f");
	}
	
}
