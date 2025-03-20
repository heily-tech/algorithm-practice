package org.example.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 24313번 - 알고리즘 수업 점근적 표기 1
 * (Time Complexity)
 */

public class BOJ_24313 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int a1 = Integer.parseInt(input[0]);
        int a0 = Integer.parseInt(input[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        // 2. 모든 n에 대해 검사하기
        for (int n = n0; n <= 100; n++) {
            if (a1 * n + a0 > c * n) {
                System.out.println(0);
                return; // 만약 참이 아닌 것이 발견되면 검사 중단
            }
        }
        System.out.println(1);
    }
}