package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 백준 7568번 - 덩치
 * (Brute Force)
 */

class Person {
    int weight, height;

    Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class BOJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);

            people.add(new Person(weight, height));  // Person 객체 저장
        }

        // 2. 등수 비교하기
        int[] rank = new int[N];
        Arrays.fill(rank, 1);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (i != j && people.get(i).weight < people.get(j).weight && people.get(i).height < people.get(j).height)
                    rank[i]++;

        // 3. 등수 한 줄에 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i : rank)
            sb.append(i).append(" ");
        System.out.println(sb.toString().trim());
    }
}
