package org.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 메모리 74984KB
 * 시간 688ms
 */

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int Q = Integer.parseInt(token.nextToken());

        // 2. 도감 생성
        Map<String, Integer> nameToIndex = new HashMap<>();
        String[] indexToName = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToIndex.put(name, i);
            indexToName[i] = name;
        }

        // 3. 조회 시스템 만들기
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0)))
                sb.append(indexToName[Integer.parseInt(input)]).append('\n');
            else
                sb.append(nameToIndex.get(input)).append('\n');
        }

        // 4. 출력
        System.out.print(sb);
    }
}
