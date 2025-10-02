import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 1. Queue 자료구조
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        long s1 = 0, s2 = 0;
        for (int n : queue1) {
            q1.offer(n);
            s1 += n;
        }
        for (int n : queue2) {
            q2.offer(n);
            s2 += n;
        }
        
        // 2. 목표값 구하기
        long goal = s1 + s2;
        if (goal % 2 != 0)
            return -1;
        goal /= 2;
        
        // 3. 
        int cnt = 0;
        int limit = queue1.length * 3;
        
        while (cnt <= limit) {
            if (s1 == goal)
                return cnt;
            
            if (s1 > goal) {
                if (q1.isEmpty())
                    break;
                int n = q1.poll();
                s1 -= n;
                q1.offer(n);
                s2 += n;
            } else {
                if (q2.isEmpty())
                    break;
                int n = q2.poll();
                s2 -= n;
                q1.offer(n);
                s1 += n;
            }
            cnt++;
        }
        return -1;
    }
}