class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        int[] nums = new int[strs.length];

        for (int i = 0; i < strs.length; i++)
            nums[i] = Integer.parseInt(strs[i]);

        return getMin(nums) + " " + getMax(nums);
    }
    
    private int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums)
            if (min > num)
                min = num;
        return min;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums)
            if (max < num)
                max = num;
        return max;
    }
}