import java.util.*;
import java.io.*;

class Main {
    static final int INF = 1_000_000_000;
    static final int[] DIRS = {-1, 0, 1}; // leftBottom, Bottom, rightBottom

    public static void main(String[] args) throws IOException {
        // 1. 값 불러오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] space = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                space[i][j] = Integer.parseInt(st.nextToken());
        }

        // 2. DP 수행 및 결과 출력
        System.out.println(getMinFuel(N, M, space));
    }


    static int getMinFuel(int N, int M, int[][] space) {
        // 배열 초기화
        int[][][] dp = new int[N][M][DIRS.length];
        for (int r = 0; r < N; r++)
            for (int c = 0; c < M; c++)
                Arrays.fill(dp[r][c], INF);
        for (int c = 0; c < M; c++) 
            Arrays.fill(dp[0][c], space[0][c]);

        // DP 수행
        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int d = 0; d < DIRS.length; d++) {
                    int prevCol = c - DIRS[d]; // c = prevCol + DIRS[d]
                    if (prevCol < 0 || prevCol >= M) 
                        continue;
                    
                    for (int prevDir = 0; prevDir < 3; prevDir++) {
                        if (prevDir == d) 
                            continue;
                        dp[r][c][d] = Math.min(dp[r][c][d], dp[r-1][prevCol][prevDir] + space[r][c]);
                    }
                }
            }
        }
        
        // 마지막 행에서 최소 연료값 찾기
        int answer = INF;
        for (int c = 0; c < M; c++)
            for (int d = 0; d < DIRS.length; d++)
                answer = Math.min(answer, dp[N-1][c][d]);
        return answer;
    }
}