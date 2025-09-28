package org.example.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 백준 2751번 - 수 정렬하기 2
 * (Sorting)
 */


public class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>(N);
        for (int i = 0; i < N; i++)
            numbers.add(Integer.parseInt(br.readLine()));

        // 2. 정렬하기
        Collections.sort(numbers);

        // 3. 출력하기
        StringBuilder sb = new StringBuilder();
        for (int num : numbers)
            sb.append(num).append("\n");
        System.out.print(sb);
    }
}
