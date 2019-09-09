package com.woniuxy.z_test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

// 服务器端
public class AppTest {
	public static void main(String[] args) throws Exception {
		// 开机
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("服务器已开启");
		// 待机，此时会阻塞，直到有客户端连接到服务器端（拨号）
		Socket client = ss.accept();
		System.out.println("有朋自远方来，不亦乐乎");
		
		
		// 获取听筒，获取输入流。 起点：客户端浏览器  终点：服务器端
		InputStream in = client.getInputStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		// 等客户端浏览器把数据发来了，才继续向下执行 
		while(in.available() == 0);
		
		while(in.available() > 0) {
			int n = in.read();
			bos.write(n);
		}
		
		byte[] bb = bos.toByteArray();
		
		// 解码 
		String str = new String(bb);
		
		
		System.out.println(str);
		
		
		client.close();
		ss.close();
	}
}
