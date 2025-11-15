import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int N = routes.length;
        List<int[]>[] movements = new ArrayList[N];
        
        // 경로 계산
        for (int i = 0; i < N; i++) {
            movements[i] = new ArrayList<>();
            int[] route = routes[i];
            
            int ny = points[route[0] - 1][0];
            int nx = points[route[0] - 1][1];
            movements[i].add(new int[]{ny, nx});
            
            for (int j = 1; j < route.length; j++) {
                int ty = points[route[j] - 1][0];
                int tx = points[route[j] - 1][1];
                
                while (ny != ty) {
                    ny += (ty > ny ? 1 : -1);
                    movements[i].add(new int[]{ny, nx});
                }
                while (nx != tx) {
                    nx += (tx > nx ? 1 : -1);
                    movements[i].add(new int[]{ny, nx});
                }
            }
        }
        
        // 충돌 계산
        int maxTime = 0;
        for (List<int[]> move : movements)
            maxTime = Math.max(maxTime, move.size());
        
        int collisions = 0;
        for (int t = 0; t < maxTime; t++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for (int i = 0; i < N; i++) {
                List<int[]> move = movements[i];
                if (t >= move.size())
                    continue;
                
                int[] pos = move.get(t);
                int y = pos[0];
                int x = pos[1];
                
                int key = y * 200 + x;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
            for (int value : map.values())
                if (value >= 2)
                    collisions++;
        }
        return collisions;        
    }
}