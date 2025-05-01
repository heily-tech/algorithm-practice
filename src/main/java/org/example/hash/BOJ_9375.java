package org.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 메모리 14280KB
 * 시간 112ms
 */

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testN = Integer.parseInt(br.readLine());
        int[] result = new int[testN];

        for (int i = 0; i < testN; i++) {
            int types = Integer.parseInt(br.readLine());

            // 2. 의상 종류별 개수 집계
            Map<String, Integer> typeCount = new HashMap<>();
            for (int j = 0; j < types; j++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                String name = token.nextToken();
                String type = token.nextToken();
                typeCount.merge(type, 1, Integer::sum);
            }

            // 3. 조합 계산
            int total = 1;
            for (int count : typeCount.values())
                total *= (count + 1);

            // 4. 결과 저장
            result[i] = total - 1;
        }
        // 5. 결과 출력
        for (int n : result)
            System.out.println(n);
    }
}
