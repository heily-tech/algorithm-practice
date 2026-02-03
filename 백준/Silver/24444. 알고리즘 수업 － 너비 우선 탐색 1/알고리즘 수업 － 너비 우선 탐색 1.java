import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph; 
    static int[] visitOrder;     
    static int order = 1;         

    public static void main(String[] args) throws Exception {
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
        

        visitOrder = new int[n + 1];
        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(visitOrder[i]).append('\n');
        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visitOrder[start] = order++;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph[u]) {
                if (visitOrder[v] == 0) {
                    visitOrder[v] = order++;
                    queue.offer(v);
                }
            }
        }
    }
}
