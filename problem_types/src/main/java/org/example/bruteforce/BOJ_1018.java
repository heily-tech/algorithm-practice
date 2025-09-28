package org.example.bruteforce;

import java.util.Scanner;

/**
 * 백준 1018번 - 체스판 다시 칠하기
 * (Brute Force)
 */

public class BOJ_1018 {
    public static void main(String[] args) {
        // 1. 입력 값 받기
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        scan.nextLine();    // 개행 문자 처리

        // 2. 초기 보드 구성하기
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < M; j++)
                board[i][j] = line.charAt(j);
        }
        scan.close();

        int minCount = Integer.MAX_VALUE;
        // 3. 8*8 크기의 체스판으로 잘라내기
        for (int x = 0; x <= N - 8; x++) {
            for (int y = 0; y <= M - 8; y++) {

                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        char current = board[x + i][y + j]; // 현재 위치

                        // 4. 체스판 검사 수행
                        if ((i+j) % 2 == 0) { // 짝수 칸
                            if (current != 'W') count1++;
                            if (current != 'B') count2++;
                        } else { // 홀수칸
                            if (current != 'B') count1++;
                            if (current != 'W') count2++;
                        }
                    }
                }
                // 5. 다시 칠해야 하는 최소 횟수 계산
                minCount = Math.min(minCount, Math.min(count1, count2));
            }
        }

        // 6. 결과 출력
        System.out.println(minCount);
    }
}