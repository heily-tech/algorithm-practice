import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
            maxHeap.offer(priorities[i]);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int index = curr[0];
            int priority = curr[1];

            if (priority < maxHeap.peek())
                queue.offer(curr);
            else {
                cnt++;
                maxHeap.poll();

                if (index == location)
                    return cnt;
            }
        }
        return cnt;
    }
}