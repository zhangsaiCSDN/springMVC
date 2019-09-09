package com.woniuxy.c_default;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

public class MyView implements View {

	@Override
	public String getContentType() {
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("ccccccccccccccccccccccc");
		request.getRequestDispatcher("c.jsp").forward(request, response);
		
		
	}

}
