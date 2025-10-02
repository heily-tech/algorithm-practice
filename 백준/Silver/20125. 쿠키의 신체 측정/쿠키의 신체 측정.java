import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static int N;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                map[i][j] = line.charAt(j);
        }
        
        int[] heart = getHeart();
        int hX = heart[0], hY = heart[1];
        
        int armLeft = getArmLength(hX, hY, -1);
        int armRight = getArmLength(hX, hY, 1);
        int waist = getWaistLength(hX, hY);
        int legLeft = getLegLength(hX, hY, waist, -1);
        int legRight = getLegLength(hX, hY, waist, 1);
        
        System.out.printf("%d %d\n", hX+1, hY+1);
        System.out.printf("%d %d %d %d %d", armLeft, armRight, waist, legLeft, legRight);
    }
    
    private static int[] getHeart() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') {
                    // 상하좌우 확인
                    if (i > 0 && j > 0 && i < N - 1 && j < N - 1 &&
                        map[i - 1][j] == '*' && map[i + 1][j] == '*' &&
                        map[i][j - 1] == '*' && map[i][j + 1] == '*') {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    private static int getArmLength(int x, int y, int dir) {
        int len = 0;
        int ny = y + dir;
        while (ny >= 0 && ny < N && map[x][ny] == '*') {
            len++;
            ny += dir;
        }
        return len;
    }
    
    private static int getWaistLength(int x, int y) {
        int len = 0;
        int nx = x + 1;
        while (nx < N && map[nx][y] == '*') {
            len++;
            nx++;
        }
        return len;
    }
    
    private static int getLegLength(int x, int y, int waist, int dir) {
        int len = 0;
        int base = x + waist + 1;
        int ny = y + dir;
        
        for (int nx = base; nx < N; nx++) {
            if (ny >= 0 && ny < N && map[nx][ny] == '*')
                len++;
            else
                break;
        }
        return len;
    }
}