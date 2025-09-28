package org.example.timecomplexity;

import java.util.Scanner;

/**
 * 백준 24262번 - 알고리즘의 수행 시간 1
 * (Time Complexity)
 */

public class BOJ_24262 {
    public static void main(String[] args) {
        // 1. 입력 받기
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        // 2. 출력하기
        System.out.println(1); // 항상 수행 횟수는 1
        System.out.println(0); // 항상 시간 복잡도는 O(1) => 차수는 항상 0
    }
}
