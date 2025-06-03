package org.example.string;

import java.util.ArrayList;
import java.util.List;

/*
 * 메모리 79600KB
 * 시간 2.74ms
 */
public class PGS_17677 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        String str1 = "FRANCE";
        String str2 = "french";

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
            // 1. 문자열 전처리
            String s1 = str1.toLowerCase();
            String s2 = str2.toLowerCase();

            // 2. 두 글자 단위 다중 집합 생성
            List<String> mulSetA = getMulSet(s1);
            List<String> mulSetB = getMulSet(s2);

            // 3. 자카드 유사도 계산
            List<String> intersection = new ArrayList<>();
            List<String> interTemp = new ArrayList<>(mulSetB);
            for (String s : mulSetA) {
                if (interTemp.contains(s)) {
                    intersection.add(s);
                    interTemp.remove(s);
                }
            }
            double interCount = intersection.size();
            double uniCount = mulSetA.size() + mulSetB.size() - intersection.size();

            // 5. 공집합 등의 예외 처리 및 반환
            return (int) ((uniCount == 0 ? 1 : interCount / uniCount) * 65536);
        }

        /*
         * 문자열을 두 글자씩 나누어 영문자만으로 구성된 쌍을 다중 집합으로 반환
         *
         * @param s 입력 문자열
         * @return  두 글자 쌍으로 나누어진 다중 집합 리스트
         */
        private List<String> getMulSet(String s) {
            List<String> mulSet = new ArrayList<>();
            for (int i = 0; i < s.length() - 1; i++) {
                String subSet = s.substring(i, i+2);
                if (subSet.matches("[a-z]{2}"))
                    mulSet.add(subSet);
            }
            return mulSet;
        }
    }
}
