import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Integer> rankMap = new HashMap<>(); // 당첨 내용, 순위
        for (int i = 0; i <= 6; i++)
            rankMap.put(i, i <= 1 ? 6 : 7-i);
        
        int cntZero = 0;
        int cntMatch = 0;
        Set<Integer> wins = new HashSet<>();
        for (int n : win_nums)
            wins.add(n);
        
        for (int n : lottos) {
            if (n == 0)
                cntZero++;
            else if (wins.contains(n))
                cntMatch++;
        }
        
        int maxRank = rankMap.get(cntMatch + cntZero);
        int minRank = rankMap.get(cntMatch);
        
        return new int[]{maxRank, minRank};
    }
}