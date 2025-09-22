package com.kh.example.api;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {
		super();
	}

	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		while(stn.hasMoreElements()) {
			sb.append(stn.nextToken());
		}
		return sb.toString();
	}
	
	public String firstCap(String input) {
		StringTokenizer stn = new StringTokenizer(input, " ");
		StringBuilder sb = new StringBuilder();
		while(stn.hasMoreElements()) {
			sb.append(stn.nextToken());
		}
		String st = sb.toString();
		st = st.substring(0,1).toUpperCase() + st.substring(1);
		return st;
	}
	
	public int findChar(String input, char one) {
		StringTokenizer stn = new StringTokenizer(input, " ");
		StringBuilder sb = new StringBuilder();
		while(stn.hasMoreElements()) {
			sb.append(stn.nextToken());
		}
		int cnt=0;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == one) {
				cnt++;
			}
		}
		return cnt;
		
	}
}
