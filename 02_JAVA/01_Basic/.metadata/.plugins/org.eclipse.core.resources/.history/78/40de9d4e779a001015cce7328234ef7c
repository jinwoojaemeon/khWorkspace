package com.kh.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	/*
	 * - 서버, 클라이언트와 1:1 소켓통신
	 * - 데이터를 교환하기에 앞서 서버, 클라이언트 연결이 되어있어야한다.
	 * 	(서버가 먼저 실행되어있어야 클라이언트의 연결요청을 받을 수 있다.)
	 * 
	 * Socket 
	 *   - 프로세스 간에 통신을 담당 
	 *   - input/ouputStream을 가지고 있음 
	 *   
	 * ServerSocket
	 *  - 포트와 연결되어 외부의 연결요청을 기다림 -> 요청이 들어오면 수락
	 *  수락 -> 통신할 수 있는 socket 생성 
	 */
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       BufferedReader br = null;
       PrintWriter pw = null;
       // 1. 포트번호 지정 
		int port = 4444;
       try {
    	   // 2. ServerSocket 객체 생성(port와 결합(bind))
    		ServerSocket server = new ServerSocket(port);
    		System.out.println("클라이언트의 요청을 기다립니다.");
    		Socket socket = server.accept();  // 요청한 사람의 정보가 들어간다
    		InetAddress clientIp = socket.getInetAddress();
    		System.out.println(clientIp.getHostAddress() + "가 연결을 요청함...");
    		
    		// 입력용 스트림(클라이언트로부터 전달된 값을 한 줄 단위로 읽기 위한 스트림)
    		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		
    		// 출력용 스트림 
    		pw = new PrintWriter(socket.getOutputStream());
    		
    		while(true) {
    			String message = br.readLine();
        		System.out.println("클라이언트로부터 전달받은 메세지 : " + message);
        		
        		System.out.println("클라이언트로 보낼 내용 : ");
        		String sendMessage = sc.nextLine();
        		
        		pw.println(sendMessage);
        		pw.flush();
    		}
        }catch(IOException e){
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