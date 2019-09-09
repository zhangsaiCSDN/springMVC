package com.woniuxy.h_httpmessageconverter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class MyHttpMessageConverter extends AbstractHttpMessageConverter<User> {

	@Override
	protected boolean supports(Class<?> clazz) {
		System.out.println("supports.....");
		return User.class == clazz;
	}

	@Override
	protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		System.out.println("readInternal.....");
		
		User user = new User();
		
		InputStream in = inputMessage.getBody();
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		while(in.available() > 0) {
			bout.write(in.read());
		}
		
		in.close();
		bout.close();
		
		byte[] bb = bout.toByteArray();
		
		String str = new String(bb);  // id--33:::name--hahah
		
		String[] strs = str.split(":::");
		
		user.setId(Integer.parseInt(strs[0].split("--")[1]));
		user.setName(strs[1].split("--")[1]);
		
		return user;
	}

	@Override
	protected void writeInternal(User t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {

		System.out.println(t+"!!!!!!!!!!!");
		
		String str = "id--"+t.getId()+":::name--"+t.getName();
		
		OutputStream out = outputMessage.getBody();
		
		out.write(str.getBytes("utf-8"));
		
		out.close();
		
	}

}
