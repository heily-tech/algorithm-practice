package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메모리 17040KB
 * 시간 140ms
 */

public class BOJ_1251 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String head, mid, tail;
        String result = "z".repeat(word.length()); // 매우 큰 초기값

        // 2. 이중 순회하기 (BruteForce)
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                // 3. 단어 세 부분으로 나누고 뒤집기
                head = reverseSubstring(word, 0, i);
                mid = reverseSubstring(word, i, j);
                tail = reverseSubstring(word, j, word.length());

                // 4. 각 부분 이어붙이기
                String candidate = head + mid + tail;

                // 5. 사전 순으로 앞서는 단어인지 점검
                if (candidate.compareTo(result) < 0)
                    result = candidate;
            }
        }

        // 6. 출력하기
        System.out.println(result);
    }

    private static String reverseSubstring(String word, int start, int end) {
        return new StringBuilder(word.substring(start, end)).reverse().toString();
    }
}
