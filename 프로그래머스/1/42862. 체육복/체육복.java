import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] s = new int[n + 2];     // 1-based
        Arrays.fill(s, 1);            // 모두 체육복 1개를 가졌다고 가정

        // 체육복 유무 반영        
        for (int l : lost) 
            s[l]--;
        for (int r : reserve) 
            s[r]++;

        // 체육복 빌리기
        for (int i = 1; i <= n; i++) {
            int left = i - 1, right = i + 1;

            if (s[i] == 0) {
                if (s[left] == 2) 
                    s[left]--;
                else if (s[right] == 2) 
                    s[right]--;
                else 
                    continue;

                s[i]++;  // 빌린 경우
            }
        }

        return (int) Arrays.stream(s, 1, n + 1)
                           .filter(x -> x >= 1)
                           .count();
    }
}
