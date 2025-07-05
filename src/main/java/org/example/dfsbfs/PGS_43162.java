package org.example.dfsbfs;

import java.util.ArrayDeque;
import java.util.Queue;

/* DFS
 * 메모리 81,790KB
 * 시간 0.08ms
 */

/* BFS
 * 메모리 82,120KB
 * 시간 0.12ms
 */

public class PGS_43162 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        int n = 3;
        int[][] computers = {   // 2
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int[][] computers2 = {  // 1
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        int result = sol.solution(n, computers2);

        // 3. 결과 출력
        System.out.println(result);
    }

    static class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] isVisited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!isVisited[i]) {
                    dfs(i, isVisited, computers);
//                    bfs(i, isVisited, computers);
                    answer++;
                }
            }

            return answer;
        }
    }

    /** DFS 재귀 방식 */
    private static void dfs(int curr, boolean[] isVisited, int[][] computers) {
        isVisited[curr] = true;

        for (int next = 0; next < computers.length; next++)
            if (curr != next && computers[curr][next] == 1 && !isVisited[next])
                dfs(next, isVisited, computers);
    }

    /** BFS 큐 방식 */
    private static void bfs(int start, boolean[] isVisited, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next = 0; next < computers.length; next++) {
                if (curr != next && computers[curr][next] == 1 && !isVisited[next]) {
                    isVisited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}