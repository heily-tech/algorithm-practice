package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 프로그래머스 12909 - 올바른 괄호
 * (Stack)
 */

public class PGS_12909 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        String s = "(()(";

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        boolean answer = sol.solution(s);

        // 3. 결과 출력
        System.out.println(answer);
    }

    static class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Deque<Character> stack = new ArrayDeque<>();
            for (char ch : s.toCharArray()) {
                if (ch == '(')
                    stack.push(ch);
                else if (stack.isEmpty())
                    answer = false;
                else
                    stack.pop();
            }
            if (!stack.isEmpty())
                answer = false;

            return answer;
        }
    }
}
