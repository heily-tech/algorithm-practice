package org.example.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 메모리 20596KB
 * 시간 224ms
 */

class Edge {
    int id;
    Edge next;

    public Edge(int id, Edge next) {
        this.id = id;
        this.next = next;
    }
}

public class BOJ_1260 {
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // nodeCount
        int M = Integer.parseInt(input[1]); // edgeCount
        int V = Integer.parseInt(input[2]); // startNodeId

        // 2. 그래프 형성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            String[] conn = br.readLine().split(" ");
            int a = Integer.parseInt(conn[0]);
            int b = Integer.parseInt(conn[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (List<Integer> neighbors : graph)
            Collections.sort(neighbors);

        // 3. DFS 실행
        isVisited = new boolean[N + 1];
        List<Integer> dfsResult = new ArrayList<>();
        dfs(graph, V, dfsResult);
        System.out.println(toOutputString(dfsResult));

        // 4. BFS 실행
        isVisited = new boolean[N + 1];
        List<Integer> bfsResult = new ArrayList<>();
        bfs(graph, V, bfsResult);
        System.out.println(toOutputString(bfsResult));
    }

    /**
     * 깊이 우선 탐색 (DFS)
     *
     * @param graph 인접 리스트로 표현된 그래프
     * @param curr 현재 방문 중인 노드
     * @param res  방문 순서를 저장할 리스트
     */
    private static void dfs(List<List<Integer>> graph, int curr, List<Integer> res) {
        isVisited[curr] = true;
        res.add(curr);
        for (int next : graph.get(curr))
            if (!isVisited[next])
                dfs(graph, next, res);
    }


    /**
     * 너비 우선 탐색 (BFS)
     *
     * @param graph 인접 리스트로 표현된 그래프
     * @param start 시작 노드
     * @param res  방문 순서를 저장할 리스트
     */
    private static List<Integer> bfs(List<List<Integer>> graph, int start, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for (int next : graph.get(curr)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return res;
    }

    /**
     * 방문 순서를 문자열로 변환
     *
     * @param list 방문 순서
     * @return 공백으로 구분된 문자열
     */
    private static String toOutputString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i : list) sb.append(i).append(" ");
        return sb.toString().trim();
    }
}
