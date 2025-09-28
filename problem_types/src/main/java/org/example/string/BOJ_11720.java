package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 메모리 14308KB
 * 시간 96ms
 */

public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = 0;

        // 2. 문자 합하기
        for (int i = 0; i < N; i++) {
            sum += s.charAt(i) - '0';
        }

        // 3. 숫자들의 합 출력하기
        System.out.println(sum);
    }
}
