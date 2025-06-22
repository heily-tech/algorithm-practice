package org.example.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/* DFS
 *
 * 메모리 80,040KB
 * 시간 1.41ms
 */

/* BFS
 *
 *  메모리 101,863KB
 * 시간 51.74ms
 */

public class PGS_43165 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        int[] numbers = {4, 1, 2, 1};
        int target = 4; // return 2

        // 2. Solution 객체 생성
        Solution sol = new Solution();

        // 3. 결과 출력
        System.out.println(sol.solution(numbers, target));
    }

    static class Solution {
        public int solution(int[] numbers, int target) {
            // DFS
            return dfs(numbers, 0, 0, target);

            // BFS
//            return bfs(numbers, target);
        }

        /** DFS 재귀 방식 */
        private int dfs(int[] numbers, int index, int sum, int target) {
            if (index == numbers.length)
                return sum == target ? 1 : 0;

            int add = dfs(numbers, index + 1, sum + numbers[index], target);
            int sub = dfs(numbers, index + 1, sum - numbers[index], target);

            return add + sub;
        }

        /** BFS 큐 방식 */
        private int bfs(int[] numbers, int target) {
            int count = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int index = curr[0];
                int sum = curr[1];

                if (index == numbers.length) {
                    if (sum == target)
                        count++;
                    continue;
                }

                int next = index + 1;
                queue.offer(new int[]{next, sum + numbers[index]});
                queue.offer(new int[]{next, sum - numbers[index]});
            }

            return count;
        }
    }
}
