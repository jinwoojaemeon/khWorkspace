
package com.kh.synthesis;

import java.util.Scanner;

public class Practice5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int groupWordCount = 0;

        for (int loop = 0; loop < N; loop++) {
            String word = sc.next();
            boolean[] used = new boolean[26]; 
            boolean isGroupWord = true;
            
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                int index = currentChar - 'a';
                
                // 현재 문자가 이미 사용되었는지 확인
                if (used[index]) {   //used[index]가 true면 사용했던 단어이다. 
                   
                    if (i > 0 && word.charAt(i - 1) != currentChar) { // 첫번째 글자가 아니고, 이전 문자와 다르면 그룹단어가 아니다.
                        isGroupWord = false;
                        break;
                    }
                } else {				//used[index]가 fasle면 사용하지 않았던 단어이다. 
                    // 처음 사용하는 문자라면 체크
                    used[index] = true;
                }
            }
            
            if (isGroupWord) {
                groupWordCount++;
            }
        }

        System.out.println(groupWordCount);
        sc.close();
    }
}