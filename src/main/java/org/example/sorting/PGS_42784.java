package org.example.sorting;

import java.util.Arrays;

/**
 * 프로그래머스 42748번 - K번째 수
 * (Sorting)
 */

public class PGS_42784 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정 (예제 이용)
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        int[] result = sol.solution(array, commands);

        // 3. 결과 출력
        System.out.println(Arrays.toString(result));

    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                // 1. array 자르기
                int[] sub = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

                // 2. 정렬하기
                Arrays.sort(sub);

                // 3. k번째 값 찾기
                // commands[i][2] 번째 값
                answer[i] = sub[commands[i][2] - 1];
            }
            return answer;
        }
    }
}
