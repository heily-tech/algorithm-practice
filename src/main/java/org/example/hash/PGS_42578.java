package org.example.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 메모리 83368KB
 * 시간 0.59ms
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
            Map<String, Integer> combinations = new HashMap<>();
            Set<String> integrity = new HashSet<>();
            int total = 1;

            // 2. 데이터 유효성 검사 (null, 중복 등) 및 데이터 구성
            for (int i = 0; i < clothes.length; i++) {
                if (!integrity.add(clothes[i][0]))
                    continue;
                combinations.merge(clothes[i][1], 1, Integer::sum);
            }

            // 3. 조합 계산
            for (int count : combinations.values())
                total *= (count + 1);
            total--;

            // 4. 결과 반환
            return total;
        }
    }
}