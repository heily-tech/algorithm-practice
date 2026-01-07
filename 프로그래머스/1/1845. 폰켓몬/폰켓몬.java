import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int avail = nums.length / 2;
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        
        if (avail > set.size())
            return set.size();
        else
            return avail;
    }    
}