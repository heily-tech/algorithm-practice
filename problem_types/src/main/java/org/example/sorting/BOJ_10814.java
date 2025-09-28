package org.example.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 10814번 - 나이순 정렬
 * (Sorting)
 */

public class BOJ_10814 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        // 2. 정렬 (Comparator 사용 → Stable Sort 유지)
        members.sort(Comparator.comparingInt(Member::getAge));

        // 3. 출력 하기
        StringBuilder sb = new StringBuilder();
        for (Member mem : members)
            sb.append(mem.age).append(' ').append(mem.name).append('\n');
        System.out.print(sb);
    }

    static class Member {
        private final int age;
        private final String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
