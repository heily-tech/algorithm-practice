import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (isBig(wallet, bill)) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        
        return answer;
    }
            
    private boolean isBig(int[] wallet, int[] bill) {
        int minBill = Math.min(bill[0], bill[1]);
        int minWall = Math.min(wallet[0], wallet[1]);
        int maxBill = Math.max(bill[0], bill[1]);
        int maxWall = Math.max(wallet[0], wallet[1]);
        
        return minBill > minWall || maxBill > maxWall;
    }
}
