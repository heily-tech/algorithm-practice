package org.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
 * 메모리 14284KB
 * 시간 100ms
 */

public class BOJ_1316 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int groupCount = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word))
                groupCount++;
        }

        System.out.println(groupCount);
    }

    private static boolean isGroupWord(String word) {
        boolean[] alphabet = new boolean[26];
        char prev = 0;

        for (char curr : word.toCharArray()) {
            if (curr != prev) {
                if (alphabet[curr - 'a'])
                    return false;
                alphabet[curr - 'a'] = true;
            }
            prev = curr;
        }
        return true;
    }

}