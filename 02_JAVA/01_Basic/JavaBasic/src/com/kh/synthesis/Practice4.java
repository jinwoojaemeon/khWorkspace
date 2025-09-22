package com.kh.synthesis;

import java.util.Scanner;

public class Practice4 {
	/*
	 * 문자열.replace("찾을문자열", "바꿀문자열");
	 * 원래 문자열에서 찾을 문자열을 검색하여 바꿀문자열로 치환한 새로운 문자열을 변환.
	 * 문자열.substring == sql > substr 사용도 가능. 
	 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int i = 0;
        int cnt = 0;

        while (i < str.length()) {
            boolean found = false;
            
            // dz= 검사 
            if (i+2 < str.length()&& 
            		str.charAt(i) == 'd' && 
            		str.charAt(i + 1) == 'z' && 
            		str.charAt(i + 2) == '=') {
                i += 3;
                cnt++;
                found = true;
            }
            else if (i+1 < str.length()) {
                char first = str.charAt(i);
                char second = str.charAt(i + 1);
                if ((first == 'c' && (second == '=' || second == '-')) ||
                    (first == 'd' && second == '-') ||
                    (first == 'l' && second == 'j') ||
                    (first == 'n' && second == 'j') ||
                    (first == 's' && second == '=') ||
                    (first == 'z' && second == '=')) {
                    i += 2;
                    cnt++;
                    found = true;
                }
            }
            if (!found) {
                i++;
                cnt++;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}