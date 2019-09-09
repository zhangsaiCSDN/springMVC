package com.woniuxy.z_test;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class AppTest2 {
	public static void main(String[] args) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write("abc".getBytes());
		
		byte[] bb = bos.toByteArray();
		
		System.out.println(Arrays.toString(bb));
		
		bos.close();
		
		
		
	}
}
