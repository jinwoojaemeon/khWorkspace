package com.kh.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
	    PrintWriter pw = null;
		// 요청하고자 하는 서버의 위치를 알아야 한다.
		// ip + port
		String serverIP = "192.168.10.15";
		int port = 4444; 
		
		try {
			// 1) 서버로 연결 요청(서버의 ip와 port로 연결을 요청)
			Socket socket = new Socket(serverIP, port);
			
			if(socket != null) {
				System.out.println("서버와 연결 성공");
				// 입력용 스트림(서버로부터 전달된 값을 한 줄 단위로 읽기 위한 스트림)
	    		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    		
	    		// 출력용 스트림 
	    		pw = new PrintWriter(socket.getOutputStream());
				
	    		while(true) {
	    			System.out.println("서버로 보낼 내용 : ");
		    		String sendMessage = sc.nextLine();
		    		pw.println(sendMessage);
		    		pw.flush();
		    		String message = br.readLine();
		    		System.out.println("서버로부터 전달받은 메세지 : " + message);
	    		}
	    		
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
        	pw.close();
        	try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	sc.close();
		
        }
		
	}

}
