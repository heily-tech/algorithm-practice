import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static List<Integer>[] graph;
    private static int[] depth;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) Collections.sort(graph[i]);
        depth = new int[n + 1];
        visited = new boolean[n + 1];

        Arrays.fill(depth, -1);
        depth[r] = 0;
        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(depth[i]).append('\n');
        System.out.print(sb);
    }

    static void dfs(int u) {
        visited[u] = true;

        for (int v : graph[u])
            if (!visited[v]) {
                depth[v] = depth[u] + 1;
                dfs(v);
            }

    }
}