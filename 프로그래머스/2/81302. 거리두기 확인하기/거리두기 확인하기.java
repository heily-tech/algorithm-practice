import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    
    // 4방향 이동 오프셋
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            char[][] room = new char[5][5];
            for (int j = 0; j < 5; j++)
                room[j] = places[i][j].toCharArray();
            answer[i] = isValidRoom(room) ? 1 : 0;
        }
        return answer;      
    }
    
    private boolean isValidRoom(char[][] room) {
        // 'P'일 때 BFS 검사 수행
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (room[i][j] == 'P')
                    if (!bfsCheck(room, i, j))
                        return false;
        return true;
    }
    
    private boolean bfsCheck(char[][] room, int cx, int cy) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{cx, cy, 0});
        visited[cx][cy] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dst = cur[2];
            
            if (dst >= 2)
                continue;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nd = dst + 1;
                
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (room[nx][ny] == 'X')
                    continue;
                
                if (room[nx][ny] == 'P')
                    return false;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, nd});
            }
        }
        return true;
    }
}