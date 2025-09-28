package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메모리 15004KB
 * 시간 116ms
 */

public class BOJ_1251 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String result = "z".repeat(word.length());

        // 2. 이중 순회하기 (BruteForce)
        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                // 3. 단어를 세 부분으로 나누고 뒤집기
                StringBuilder sb = new StringBuilder();
                sb.append(reverse(word, 0, i));
                sb.append(reverse(word, i, j));
                sb.append(reverse(word, j, word.length()));

                String candidate = sb.toString();

                // 4. 사전순으로 더 앞서는 경우 갱신
                if (candidate.compareTo(result) < 0)
                    result = candidate;
            }
        }

        // 5. 결과 출력
        System.out.println(result);
    }

    /**
     * 문자열 word의 start부터 end-1 범위를 뒤집어 문자열로 반환
     *
     * @param word  전체 문자열
     * @param start 시작 인덱스
     * @param end   끝 인덱스
     * @return      지정된 범위를 뒤집은 문자열
     */
    private static String reverse(String word, int start, int end) {
        char[] chars = word.substring(start, end).toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
