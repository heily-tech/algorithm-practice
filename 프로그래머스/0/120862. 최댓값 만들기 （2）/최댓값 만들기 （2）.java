import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
    	if (numbers == null || numbers.length < 2)
        	throw new IllegalArgumentException("최소 2개의 수가 필요합니다.");
	    if (Arrays.stream(numbers).allMatch(n -> n == 0)) {
    	    return 0;
    	}
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                max = Math.max(max, numbers[i] * numbers[j]);
            }
        }

        return max;
    }
}