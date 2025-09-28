package org.example.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 메모리 19988KB
 * 시간 240ms
 */

public class BOJ_1260 {
    private static List<List<Integer>> graph;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken()); // 정점 수
        final int M = Integer.parseInt(st.nextToken()); // 간선 수
        final int V = Integer.parseInt(st.nextToken()); // 시작 정점

        // 2. 그래프 형성
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (List<Integer> neighbors : graph)
            Collections.sort(neighbors);

        // 3. DFS 실행
        isVisited = new boolean[N + 1];
        List<Integer> dfsResult = new ArrayList<>();
        dfs(V, dfsResult);
        System.out.println(toOutputString(dfsResult));

        // 4. BFS 실행
        isVisited = new boolean[N + 1];
        List<Integer> bfsResult = bfs(V);
        System.out.println(toOutputString(bfsResult));
    }

    /** 깊이 우선 탐색 (재귀) */
    private static void dfs(int curr, List<Integer> result) {
        isVisited[curr] = true;
        result.add(curr);
        for (int next : graph.get(curr)) {
            if (!isVisited[next]) {
                dfs(next, result);
            }
        }
    }

    /** 너비 우선 탐색 (큐 기반) */
    private static List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        isVisited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int next : graph.get(curr)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    /** 방문 순서를 문자열로 변환 */

    private static String toOutputString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i : list)
            sb.append(i).append(" ");
        return sb.toString().trim();
    }
}
