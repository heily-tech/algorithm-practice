package org.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 메모리 53900KB
 * 시간 1172ms
 */

public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2. 입장,퇴장 알고리즘 (HashSet)
        Set<String> office = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter"))
                office.add(name);
            else
                office.remove(name);
        }

        // 3. 이름 정렬 출력
        List<String> sortedEmp = new ArrayList<>(office);
        Collections.sort(sortedEmp, Collections.reverseOrder());

        for (String name : sortedEmp)
            System.out.println(name);
    }
}
