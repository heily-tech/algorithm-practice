package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메모리 14220KB
 * 시간 100ms
 */

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int groupCount = 0;

        for (int i = 0; i < N; i++) {
            boolean[] alphabet = new boolean[26];
            boolean isGroupWord = true;

            String word = br.readLine();
            
            // 2. 그룹 단어 판단
            char prev = word.charAt(0);
            alphabet[prev - 'a'] = true;

            for (int j = 1; j < word.length(); j++) {
                char curr = word.charAt(j);

                if (curr != prev) {
                    if (alphabet[curr - 'a']) { // 이전 문자와 다르고, 등장한 적이 있음
                        isGroupWord = false;
                        break;
                    }
                    // 이전 문자와 다르고, 등장한 적이 없음
                    alphabet[curr - 'a'] = true;
                }
                prev = curr;
            }

            // 3. 그룹 단어 개수 저장
            if (isGroupWord)
                groupCount++;
        }

        // 4. 결과 출력
        System.out.println(groupCount);
    }
}
