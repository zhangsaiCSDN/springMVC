package com.woniuxy.f_parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String, Date> {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
	/*
	 该方法的参数，接受的就是表单里的值。
	 该方法的返回值，就是要给目标的值。
	*/
	@Override
	public Date convert(String source) {
		System.out.println("表单里的值:" + source);
		try {
			Date dd = sdf.parse(source);
			return dd;
		} catch (ParseException e) {
			try {
				Date dd = sdf2.parse(source);
				return dd;
			} catch (ParseException e1) {
				throw new RuntimeException(e1);
			}
		}
	}  
	
}
