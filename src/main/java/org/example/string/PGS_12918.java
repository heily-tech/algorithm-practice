package org.example.string;

/*
 * 메모리 81419KB
 * 시간 0.0343ms
 */
public class PGS_12918 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        String s = "a234";      // false
        String s1 = "1234";     // true
        String s2 = "12345";    // false

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        boolean res = sol.solution(s2);

        // 3. 결과 출력
        System.out.println(res);
    }

    static class Solution {
        public boolean solution(String s) {
            // 문자열 검사
            if (s.length() == 4 || s.length() == 6) {
                for (char c : s.toCharArray())
                    if (!Character.isDigit(c))
                        return false;
                return true;
            } else
                return false;
        }
    }
}
