import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {        
        // 1. 값 불러오기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        
        char[] table = br.readLine().toCharArray();
        int eaten = 0;
        
        // 2. P를 기준으로 순회
        for (int i = 0; i < N; i++) {
            if (table[i] != 'P')
                continue;
            
            int left = Math.max(0, i - K);
            int right = Math.min(N - 1, i + K);
            for (int j = left; j <= right; j++) {
                if (table[j] == 'H') {
                    table[j] = 'O';
                    eaten++;
                    break;
                }
            }
        }
        
//        for (char c : table)
//            System.out.print(c);
        System.out.println(eaten);
    }
}