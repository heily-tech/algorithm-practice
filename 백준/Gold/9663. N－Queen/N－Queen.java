import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] queen;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queen = new int[N];
        for (int i = 0; i < N; i++) {
            queen[i] = -1;
        }

        backtrack(0);

        System.out.println(count);
    }

    static void backtrack(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            queen[row] = col;
            if (isPossible(row)) backtrack(row + 1); 
            queen[row] = -1;
        }
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == queen[row]) return false;
            if (Math.abs(row - i) == Math.abs(queen[row] - queen[i])) return false;
        }
        return true;
    }
}