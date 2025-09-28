package org.example.string;

import java.util.HashMap;
import java.util.Map;

/*
 * 메모리 74830KB
 * 시간 17.29ms
 */
public class PGS_17677 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        int similarity = sol.solution(str1, str2);

        // 3. 결과 출력
        System.out.println(similarity);
    }

    static class Solution {
        /**
         * 두 문자열 간의 자카드 유사도를 계산해 65536을 곱한 정수로 반환
         *
         * @param str1  첫 번째 문자열
         * @param str2  두 번째 문자열
         * @return      자카드 유사도 * 65536 (정수형)
         */
        public int solution(String str1, String str2) {
            // 1. 두 글자 단위 다중 집합 생성
            Map<String, Integer> mulSetA = getMulSet(str1.toLowerCase());
            Map<String, Integer> mulSetB = getMulSet(str2.toLowerCase());

            // 2. 자카드 유사도 계산
            int interCount = 0;
            int uniCount = 0;

            for (String key : mulSetA.keySet()) {
                int countA = mulSetA.get(key);
                int countB = mulSetB.getOrDefault(key, 0);

                interCount += Math.min(countA, countB);
                uniCount += Math.max(countA, countB);
            }

            for (String key : mulSetB.keySet())
                if (!mulSetA.containsKey(key))
                    uniCount += mulSetB.get(key);  // 누락된 B의 원소 추가

            return (int) ((uniCount == 0 ? 1.0 : (double) interCount / uniCount) * 65536);
        }

        /**
         * 입력 문자열을 영문자 쌍의 다중 집합으로 변환
         *
         * @param s 입력 문자열 (소문자)
         * @return 문자열 쌍의 개수를 저장한 Map
         */
        private Map<String, Integer> getMulSet(String s) {
            Map<String, Integer> mulSet = new HashMap<>();

            for (int i = 0; i < s.length() - 1; i++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(i + 1);

                // 영문자 쌍인지 검사
                if (Character.isLetter(c1) && Character.isLetter(c2)) {
                    String subSet = "" + c1 + c2;
                    mulSet.put(subSet, mulSet.getOrDefault(subSet, 0) + 1);
                }
            }
            return mulSet;
        }
    }
}
