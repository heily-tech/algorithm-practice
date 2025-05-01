package org.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * 메모리 14280KB
 * 시간 112ms
 */

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int types = Integer.parseInt(br.readLine());
            Map<String, Integer> typeCount = new HashMap<>();

            // 2. 의상 종류별 개수 집계
            for (int j = 0; j < types; j++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];
                typeCount.merge(type, 1, Integer::sum);
            }

            // 3. 조합 계산
            int total = 1;
            for (int count : typeCount.values())
                total *= (count + 1);

            // 4. 결과 출력
            System.out.println(total - 1);
        }
    }
}
