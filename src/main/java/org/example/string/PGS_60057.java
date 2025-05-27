package org.example.string;

import javax.swing.*;

/*
 * 메모리 89600KB
 * 시간 10.50ms
 */

public class PGS_60057 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        int len = sol.solution(s2);

        // 3. 결과 출력
        System.out.println(len);
    }

    static class Solution {
        public int solution(String s) {
            int minLength = s.length();

            // 1. 압축 단위 모두 시도
            for (int unit = 1; unit <= s.length() / 2; unit++) {
                int compressedLength = getCompressedLength(s, unit);
                minLength = Math.min(minLength, compressedLength);
            }

            return minLength;
        }

        /**
         * 문자열 s를 unit으로 압축했을 때의 길이를 반환
         *
         * @param s     주어진 문자열
         * @param unit  압축 단위
         * @return
         */
        private int getCompressedLength(String s, int unit) {
            String compressed = "";
            String prev = s.substring(0, unit);
            int repCount = 1;

            // 2. 문자열을 단위 순회하며 압축
            for (int i = unit; i < s.length(); i += unit) {
                String curr = s.substring(i, Math.min(i + unit, s.length())); // IndexOutOfBoundsException 방지

                if (curr.equals(prev))
                    repCount++;
                else {
                    if (repCount > 1)
                        compressed += repCount;
                    compressed += prev;

                    prev = curr;
                    repCount = 1;
                }
            }

            // 3. 마지막 블록 처리
            if (repCount > 1)
                compressed += repCount;
            compressed += prev;

            return compressed.length();
        }
    }
}
