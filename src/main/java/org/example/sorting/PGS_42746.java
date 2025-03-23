package org.example.sorting;

import java.util.Arrays;

/**
 * 프로그래머스 42746번 - 가장 큰 수
 * (Sorting)
 */

public class PGS_42746 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정 (예제 이용)
        int[] numbers = {9, 98, 999};

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        String answer = sol.solution(numbers);

        // 6. 결과 출력
        System.out.println(answer);
    }

    static class Solution {
        public String solution(int[] numbers) {
            // 3. 문자열 비교를 위한 배열 요소 자료형 변환
            String[] strings = Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);

            // 4. 문자열 비교 정렬
            Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

            // 5. 문자열 결합 후 반환
            if (strings[0].equals("0")) return "0";
            return String.join("", strings);
        }
    }
}