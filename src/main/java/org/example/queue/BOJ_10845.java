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

        // 2. 큐 구현 (ArrayList)
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            switch (command.split(" ")[0]) {
                case "push":
                    queue.addLast(Integer.parseInt(command.split(" ")[1]));
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.pollFirst());
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
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

/*
15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front
 */