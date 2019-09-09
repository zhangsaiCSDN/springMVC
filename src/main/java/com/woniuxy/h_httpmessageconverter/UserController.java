package com.woniuxy.h_httpmessageconverter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("f1")
	public void f1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// ��ȡ����ͷ�е�Accpetͷ��
		String accept = req.getHeader("Accept");
		
		System.out.println(accept);
		
		PrintWriter out = resp.getWriter();
		if("application/json".equals(accept)) {
			out.println("{\"id\":2,\"name\":\"andy\"}");
		} else {
			out.println("abccc");
		}
	}

	// ֻ���β�ǰ����@RequestBodyע�� --> ������ȡ����ͷ�е�content-type: application/json
	// application/json: 		String    Jackson
	// supports:				false     true
	
	@RequestMapping("f2")
	public void f2(@RequestBody User user) {
		System.out.println("f2:" + user);
	}
	
	

	// @ResponseBody --> Accpet : a/b
	// a/b: 		StringHttpMessageConverter  MyHttpMessageConverter
	// supports:		false						true
	
	@RequestMapping("f3")
	@ResponseBody
	public User f3() {
		User user = new User();
		user.setId(88);
		user.setName("��ѧ��");
		user.setBirthday(new Date());
		user.setMoney(888d);
		return user;
	}
	
	// @ResponseBody-->Accpet-->application/json-->String,MappingJackson
	// supports:
	// MappingJackson write
	@RequestMapping("f4")
	@ResponseBody
	public List<User> f4() {
		List<User> list = new ArrayList<>();
		
		User user = new User();
		user.setId(99);
		user.setName("����");
		user.setBirthday(new Date());
		user.setMoney(999d);
		
		User user2 = new User();
		user2.setId(100);
		user2.setName("������");
		user2.setBirthday(new Date());
		user2.setMoney(999d);
		
		list.add(user);
		list.add(user2);
		
		return list;
	}
	
	
}
