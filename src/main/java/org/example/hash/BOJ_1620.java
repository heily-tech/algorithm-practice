package org.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 메모리 114432KB
 * 시간 1180ms
 */

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int Q = Integer.parseInt(token.nextToken());

        // 2. 포켓몬 도감 만들기 (이름, 인덱스)
        Map<String, Integer> pokemon = new HashMap<>();
        String[] names = new String[N];
        for (int i = 1; i < N+1; i++) {
            String input = br.readLine();
            pokemon.put(input, i);
            names[i-1] = input;
        }

        // 3. 조회 시스템 만들기
        for (int i = 0; i < Q; i++) {
            String input = br.readLine();
            if (input.matches("\\d+"))
                System.out.println(names[Integer.parseInt(input)-1]);
            else
                System.out.println(pokemon.get(input));
        }
    }
}
