package com.woniuxy.z_test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

// ��������
public class AppTest {
	public static void main(String[] args) throws Exception {
		// ����
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("�������ѿ���");
		// ��������ʱ��������ֱ���пͻ������ӵ��������ˣ����ţ�
		Socket client = ss.accept();
		System.out.println("������Զ�����������ֺ�");
		
		
		// ��ȡ��Ͳ����ȡ�������� ��㣺�ͻ��������  �յ㣺��������
		InputStream in = client.getInputStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		// �ȿͻ�������������ݷ����ˣ��ż�������ִ�� 
		while(in.available() == 0);
		
		while(in.available() > 0) {
			int n = in.read();
			bos.write(n);
		}
		
		byte[] bb = bos.toByteArray();
		
		// ���� 
		String str = new String(bb);
		
		
		System.out.println(str);
		
		
		client.close();
		ss.close();
	}
}
