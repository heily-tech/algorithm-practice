package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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

        StringBuilder result = new StringBuilder();
        OperationStack stack = new OperationStack(result);
        int currentNum = 1;
        boolean isValid = true;

        // 2. 수열 검사
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            while (currentNum <= input)
                stack.push(currentNum++);

            if (stack.peek() != null && stack.peek() == input)
                stack.pop();
            else {
                isValid = false;
                break;
            }
        }

        // 3. 출력 하기
        System.out.println(isValid ? result : "NO");
    }

    // Wrapper Class
    static class OperationStack {
        private final Deque<Integer> stack = new ArrayDeque<>();
        private final StringBuilder sb;

        public OperationStack(StringBuilder sb) {
            this.sb = sb;
        }

        public void push(int x) {
            stack.push(x);
            sb.append("+\n");
        }
        public void pop() {
            stack.pop();
            sb.append("-\n");
        }
        public Integer peek() {
            return stack.peek();
        }
    }
}