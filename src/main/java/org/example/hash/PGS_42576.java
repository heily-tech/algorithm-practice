package org.example.hash;

import java.util.HashMap;
import java.util.Map;

/*
 * 메모리 86170KB
 * 시간 30ms
 */

public class PGS_42576 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        String result = sol.solution(participant, completion);

        // 3. 결과 출력
        System.out.println(result);
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            // 1. HashMap 정의
            Map<String, Integer> nonFinisher = new HashMap<>();

            // 2. 참가자 구성
            for (int i = 0; i < participant.length; i++)
                 nonFinisher.merge(participant[i], 1, Integer::sum);

            // 3. 완주자 검사
            for (int i = 0; i < completion.length; i++)
                nonFinisher.compute(completion[i], (key, val) -> val == 1 ? null : val -1);

            // 4. 결과 출력
            return nonFinisher.keySet().iterator().next();
        }
    }
}