package org.example.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 메모리 14648KB
 * 시간 136ms
 */

public class BOJ_2178 {
    static int N, M;
    static int[][] maze;
    static int[][] distance;
    static boolean[][] visited;

    static final int[] dx = {-1, 1, 0, 0}; // 상하
    static final int[] dy = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        maze = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        // 2. 미로 정보 저장
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = row.charAt(j) - '0';
            }
        }

        // 3. BFS 방식
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        distance[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && maze[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        distance[nx][ny] = distance[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});

                        // 도착 지점 도달 시 바로 종료
                         if (nx == N - 1 && ny == M - 1)
                             return distance[nx][ny];
                    }
                }
            }
        }
        return distance[N - 1][M - 1];
    }
}