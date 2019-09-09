package com.woniuxy.h_httpmessageconverter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) throws Exception {
		ObjectMapper om = new ObjectMapper();
		
		om.setDateFormat(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"));
		
		List<User> list = new ArrayList<>();
		
		User user = new User();
		user.setId(99);
		user.setName("黎明");
		user.setBirthday(new Date());
		user.setMoney(999d);
		
		User user2 = new User();
		user2.setId(100);
		user2.setName("郭富城");
		user2.setBirthday(new Date());
		user2.setMoney(999d);
		
		list.add(user);
		list.add(user2);
		
		String json = om.writeValueAsString(list);
		System.out.println(json);
		
		
//		String json = "{\"id\":10,\"name\":\"刘德华\",\"birthday\":1567495627389,\"money\":999.0}";
//		User user = om.readValue(json, User.class);
//		System.out.println(user);
	}
}
