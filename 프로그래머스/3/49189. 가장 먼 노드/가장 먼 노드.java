import java.io.IOException;
import java.util.*;

class Solution {
   public static int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edge) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        int maxDist = getMaxDist(n, dist, graph);

        int cnt = 0;
        for (int i = 1; i <= n; i++)
            if (dist[i] == maxDist)
                cnt++;

        return cnt;
    }

    private static int getMaxDist(int n, int[] dist, List<Integer>[] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int nxt : graph[curr]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[curr] + 1;
                    queue.offer(nxt);
                }
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= n; i++)
            maxDist = Math.max(maxDist, dist[i]);

        return maxDist;
    }

}
