package org.example.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * 메모리 61156KB
 * 시간 1292ms
 */


public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2. 입장,퇴장 알고리즘 (HashSet)
        HashSet<String> inOfficeSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String[] log = br.readLine().split(" ");
            if (log[1].equals("enter"))
                inOfficeSet.add(log[0]);
            else if (log[1].equals("leave"))
                inOfficeSet.remove(log[0]);
        }

        // 3. 이름 정렬 출력
        List<String> inOffice = new ArrayList<>(inOfficeSet);
        Collections.sort(inOffice, Collections.reverseOrder());

        for (String name : inOffice)
            System.out.println(name);
    }
}