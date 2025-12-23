import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Shortcut {
    int src;
    int dest;
    int cost;

    public Shortcut(int src, int dest, int cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int D = Integer.parseInt(token.nextToken());

        List<Shortcut> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(token.nextToken());
            int dest = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());

            if (dest <= D && dest - src > cost)
                shortcuts.add(new Shortcut(src, dest, cost));
        }

        System.out.println(getShortestPath(D, shortcuts));
    }

    private static int getShortestPath(int D, List<Shortcut> shortcuts) {
        int[] dp = new int[D+1];
        for (int i = 0; i <= D; i++)
            dp[i] = i;

        for (int i = 0; i <= D; i++) {
            if (i > 0)
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            for (Shortcut sc : shortcuts)
                if (sc.src == i)
                    dp[sc.dest] = Math.min(dp[sc.dest], dp[i] + sc.cost);
        }
        return dp[D];
    }
}