package org.example.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 프로그래머스 42584번 - 주식가격
 * (Sorting)
 */

public class PGS_42584 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        int[] prices = {1, 2, 3, 2, 3};

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        int[] answer = sol.solution(prices);

        // 3. 결과 출력
        System.out.println(Arrays.toString(answer));

    }

    static class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n];
            Deque<Integer> stack = new ArrayDeque<>();

            // 1. 가격이 유지된 시간 계산 (현재 가격 >= 스택의 top)
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && prices[i] < prices[stack.peekLast()]) {
                    int topIndex = stack.removeLast();
                    answer[topIndex] = i - topIndex;
                }
                stack.addLast(i);
            }

            // 2. 끝까지 가격이 유지된 경우 처리
            while (!stack.isEmpty()) {
                int topIndex = stack.removeLast();
                answer[topIndex] = (n - 1) - topIndex;
            }
            return answer;
        }
    }
}
