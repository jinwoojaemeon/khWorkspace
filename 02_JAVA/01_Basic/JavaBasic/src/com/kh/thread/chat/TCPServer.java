package com.kh.thread.chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(3000);
			System.out.println("클라이언트의 요청을 기다립니다.");
    		Socket socket = server.accept();  // 요청한 사람의 정보가 들어간다
    		InetAddress clientIp = socket.getInetAddress();
    		System.out.println(clientIp.getHostAddress() + "가 연결을 요청함...");
			
    		ServerReceive sr = new ServerReceive(socket);
    		sr.start();
    		
    		ServerSend ss = new ServerSend(socket);
    		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
