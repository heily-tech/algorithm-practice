import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0; // mid 시간 내 처리 가능한 사람 수
            for (int t : times)
                count += mid / t;

            if (count >= n) {
                answer = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
