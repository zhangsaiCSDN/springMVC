package com.woniuxy.f_parameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String, Date> {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
	/*
	 �÷����Ĳ��������ܵľ��Ǳ����ֵ��
	 �÷����ķ���ֵ������Ҫ��Ŀ���ֵ��
	*/
	@Override
	public Date convert(String source) {
		System.out.println("�����ֵ:" + source);
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
