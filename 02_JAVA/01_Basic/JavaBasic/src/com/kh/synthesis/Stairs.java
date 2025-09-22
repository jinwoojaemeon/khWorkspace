package com.kh.synthesis;

import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int top = sc.nextInt();
        int[] stairs = new int[301];
        int[] dp = new int[301];
        
        for (int i = 1; i <= top; i++) {
            stairs[i] = sc.nextInt();
        }
        
        // 초기값 설정
        dp[1] = stairs[1];
        if (top >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        
        // 동적계획법
        for (int i = 3; i <= top; i++) {
            // 두 가지 경우 중 최댓값 선택
            // 1) i-2번째에서 점프해서 i번째로 (i-1 계단 안 밟음)
            // 2) i-3번째에서 i-1번째를 거쳐 i번째로 (연속 2계단)
            dp[i] = Math.max(dp[i-2] + stairs[i], 
                           dp[i-3] + stairs[i-1] + stairs[i]);
        }
        
        System.out.println(dp[top]);
        sc.close();
    }
}