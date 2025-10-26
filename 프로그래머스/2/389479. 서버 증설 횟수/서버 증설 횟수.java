import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        int active = 0, cnt  = 0;
        int[] expire = new int[n + k + 1];

        for (int i = 0; i < n; i++) {
            active -= expire[i];

            int required = players[i] / m;
            if (required > active) {
                int newServer = required - active;
                cnt += newServer;
                expire[i + k] += newServer;
                active = required;
            }
        }

        return cnt;
    }
}
