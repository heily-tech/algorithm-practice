import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 1. 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[] visit = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            visit[i] = Integer.parseInt(st.nextToken());
        
        // 2. 기간 별 방문자 계산 (슬라이딩 윈도우)
        int sum = 0, max = 0;        // 8_000 * 250_000 = 2_000_000_000
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            sum += visit[i];
            if (i >= x)
                sum -= visit[i - x]; // 왼쪽 소거
            
            if (i >= x - 1) {       // 0-base
                if (sum > max) {
                    max = sum;
                    cnt = 1;
                } else if (sum == max) {
                    cnt++;
                }
            }
        }
        if (max == 0)
            System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}