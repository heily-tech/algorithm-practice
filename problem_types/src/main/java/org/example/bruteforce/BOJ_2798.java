package org.example.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2798번 - 블랙잭
 * (Brute Force)
 */

public class BOJ_2798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 입력 받기
        int N = scanner.nextInt(); // 카드 개수
        int M = scanner.nextInt(); // 최대 합

        int[] cards = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = scanner.nextInt();

        scanner.close();

        // 2. 배열 정렬 (탐색 순서 최적화)
        Arrays.sort(cards);

        // 3. 완전 탐색 (O(N³))
        int maxSum = 0;
        int bestCard1 = 0, bestCard2 = 0, bestCard3 = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum == M) {
                        System.out.printf("%d\n%d %d %d\n", sum, cards[i], cards[j], cards[k]);
                        return;
                    }

                    if (sum < M && sum > maxSum) {
                        maxSum = sum;
                        bestCard1 = cards[i];
                        bestCard2 = cards[j];
                        bestCard3 = cards[k];
                    }
                }
            }
        }
        // 4. 최댓값 출력 및 조합 출력
        System.out.printf("%d\n%d %d %d\n", maxSum, bestCard1, bestCard2, bestCard3);
    }
}