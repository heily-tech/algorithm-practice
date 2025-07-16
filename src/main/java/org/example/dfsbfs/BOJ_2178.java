package org.example.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * DFS
 * 시간 초과
 *
 * BFS
 * 메모리 14656KB
 * 시간 140ms
 */

public class BOJ_2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 행 변화 (상, 하)
    static int[] dy = {0, 0, -1, 1}; // 열 변화 (좌, 우)

    static int minLength = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        // 2. 미로 정보 저장
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++)
                maze[i][j] = row.charAt(j) - '0';
        }

        // 3. DFS 방식
//        dfs(0, 0, 1);
//        System.out.println(minLength);

        // 4. BFS 방식
        System.out.println(bfs(0, 0));
    }

    /** DFS 방식 */
    private static void dfs(int x, int y, int length) {
        if (x == N - 1 && y == M - 1) {
            minLength = Math.min(minLength, length);
            return;
        }

        visited[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                if (!visited[nx][ny] && maze[nx][ny] == 1)
                    dfs(nx, ny, length + 1);
        }

        visited[x][y] = false;  // 백트래킹
    }

    /** BFS 방식 */
    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[cx][cy] + 1;
                    }
                }
            }
        }
        return maze[N - 1][M - 1];
    }
}
