package org.example.hash;

import java.util.HashMap;
import java.util.Map;

/*
 * 메모리 82863KB
 * 시간 0.55ms
 */

public class PGS_42578 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        int result = sol.solution(clothes);

        // 3. 결과 출력
        System.out.println(result);
    }

    static class Solution {
        public int solution(String[][] clothes) {
            // 1. HashMap 정의
            Map<String, Integer> typeCount = new HashMap<>();

            // 2. 데이터 구성
            for (String[] item : clothes)
                typeCount.merge(item[1], 1, Integer::sum);

            // 3. 조합 계산
            int total = 1;
            for (int count : typeCount.values())
                total *= (count + 1);

            // 4. 결과 반환
            return total - 1;
        }
    }
}