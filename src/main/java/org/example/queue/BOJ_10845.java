package org.example.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 10845번 - 큐
 * (Queue)
 */

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2. 큐 구현 (LinkedList)
        Queue<Integer> queue = new LinkedList<>();
        int last = -1;
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            switch (command.split(" ")[0]) {
                case "push":
                    last = Integer.parseInt(command.split(" ")[1]);
                    queue.offer(last);
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : last);
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                default:
                    System.out.println("Invalid Command.");
            }
        }
    }
}