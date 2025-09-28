package org.example.bruteforce;

import java.util.Scanner;

/**
 * 백준 2231번 - 분해합
 * (Brute Force)
 */

public class BOJ_2231 {
    public static void main(String[] args) {
        // 1. 입력 받기
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();

        int result = 0; // 초기값 설정

        // 2. for문을 이용해서 합이 N을 형성하는 가장 작은 생성자 찾기
        for (int i = 1; i < N; i++) {
            int sum = i;
            int num = i;

            // 3. i의 각 자리를 분해해서 sum에 더하기
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            // 4. sum과 N을 비교하기
            if (sum == N) {
                result = i;
                break;
            }
        }

        // 5. for문이 종료될 때까지 생성자를 찾지 못하면 출력은 0이 됨
        System.out.println(result);
    }
}