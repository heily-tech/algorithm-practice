import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;
        int types = new HashSet<>(Arrays.asList(gems)).size();
        
        Map<String, Integer> freq = new HashMap<>();
        int left = 0;
        int bestL = 0, bestR = n - 1;
        int bestLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            freq.merge(gems[right], 1, Integer::sum);
            
            while (freq.size() == types) {
                int currLen = right - left;
                if (currLen < bestLen || (currLen == bestLen && left < bestL)) {
                    bestLen = currLen;
                    bestL = left;
                    bestR = right;
                }
                freq.compute(gems[left], (k, v) -> v == 1 ? null : v - 1);  // update
                left++;
            }
        }
        
        // 1-base
        return bestLen == Integer.MAX_VALUE ? new int[]{1, 1} : new int[]{bestL + 1, bestR + 1};
    }
}