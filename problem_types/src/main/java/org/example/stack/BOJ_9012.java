package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 백준 9012번 - 괄호
 * (Stack)
 */

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 2. VPS 검사
        while (T-- > 0) {
            String ps = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            for (char ch : ps.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else if (stack.isEmpty()) {
                    isValid = false;
                    break;
                } else stack.pop();
            }

            // 3. 출력하기
            System.out.println((isValid && stack.isEmpty() ? "YES" : "NO"));
        }
    }
}