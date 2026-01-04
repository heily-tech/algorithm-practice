import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 볼의 총 개수
        char[] balls = br.readLine().toCharArray();

        int result = IntStream.of(
                getMoveCount(N, balls, 'R', 1),
                getMoveCount(N, balls, 'R', -1),
                getMoveCount(N, balls, 'B', 1),
                getMoveCount(N, balls, 'B', -1)
        ).min().getAsInt();

        System.out.println(result);
    }

    public static int getMoveCount(int N, char[] balls, char color, int dir) {
        int total = 0;
        for (int i = 0; i < N; i++)
            if (balls[i] == color)
                total++;

        int start = (dir == 1) ? 0 : N - 1;
        int end = (dir == 1) ? N : -1;

        int moved = 0;
        for (int i = start; i != end; i += dir)
            if (balls[i] == color)
                moved++;
            else
                break;

        return total - moved;
    }
}