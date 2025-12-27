import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* DFS
 * 메모리 KB
 * 시간 ms
 */

/* BFS
 * 메모리 16116KB
 * 시간 140ms
 */

public class Main {
    static int T;       // 테스트 케이스 수
    static int M, N, K; // 가로, 세로, 배추 개수
    static int x, y;    // 배추의 좌표
    static final int[] dx = {-1, 1, 0, 0}; // 상하
    static final int[] dy = {0, 0, -1, 1}; // 좌우


    static int[][] field;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        // 1. 테스트 케이스 수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        // 2. 각 테스트 케이스 입력
        for (int i = 0; i < T; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            M = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());

            field = new int[M][N];
            isVisited = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                // 3. 배추 좌표 입력
                token = new StringTokenizer(br.readLine());
                x = Integer.parseInt(token.nextToken());
                y = Integer.parseInt(token.nextToken());
                field[x][y] = 1;
            }

            // 4. 배추 군집 계산
            int group = 0;
            for (int k = 0; k < M; k++) {
                for (int l = 0; l < N; l++) {
                    if (field[k][l] == 1 && !isVisited[k][l]) {
                        dfs(k, l, isVisited, field);
                        //bfs(k, l, isVisited, field);
                        group++;
                    }
                }
            }
            System.out.println(group);
        }
    }

    /** DFS 방식 */
    private static void dfs(int cx, int cy, boolean[][] isVisited, int[][] field) {
        isVisited[cx][cy] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N)
                if (!isVisited[nx][ny] && field[nx][ny] == 1)
                    dfs(nx, ny, isVisited, field);
        }
    }

    /** BFS 방식 */
    private static void bfs(int x, int y, boolean[][] isVisited, int[][] field) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!isVisited[nx][ny] && field[nx][ny] == 1) {
                        isVisited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
