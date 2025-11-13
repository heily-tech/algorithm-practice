import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int rows = park.length;
        int cols = park[0].length;
        
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            if (isValid(size, park, rows, cols))
                return size;
        }
        return -1;
    }
    
    private boolean isValid(int size, String[][] park, int rows, int cols) {
        for (int y = 0; y + size <= rows; y++)
            for (int x = 0; x + size <= cols; x++)
                if (isEmpty(y, x, size, park))
                    return true;
        return false;
    }
    
    private boolean isEmpty(int sy, int sx, int size, String[][] park) {
        for (int y = sy; y < sy + size; y++)
            for (int x = sx; x < sx + size; x++)
                if (!park[y][x].equals("-1"))
                    return false;
        return true;
    }
}