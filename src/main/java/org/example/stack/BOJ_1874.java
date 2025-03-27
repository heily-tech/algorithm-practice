package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 백준 1874번 - 스택 수열
 * (Stack)
 */

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<String> result = new ArrayList<>();
        int curr = 1;
        boolean isValid = true;

        // 2. 수열 검사
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            while (curr <= input) {
                stack.push(curr++);
                result.add("+");
            }

            if (stack.peek() == input) {
                stack.pop();
                result.add("-");
            } else {
                isValid = false;
                break;
            }
        }

        // 3. 출력 하기
        if (isValid)
            for (String op : result)
                System.out.println(op);
        else
            System.out.println("NO");
    }
}