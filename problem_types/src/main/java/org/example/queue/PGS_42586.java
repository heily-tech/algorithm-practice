package org.example.queue;

import java.util.*;

/**
 * 프로그래머스 42586번 - 기능 개발
 * (Sorting)
 */

/*
 * progresses speeds return
 * [93, 30, 55]	[1, 30, 5]	[2, 1]
 * [95, 90, 99, 99, 80, 99] [1, 1, 1, 1, 1, 1] [1, 3, 2]
 */

public class PGS_42586 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        int answer[] = sol.solution(progresses, speeds);

        // 3. 결과 출력
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> result = new ArrayList<>();
            int prevDay = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
            int count = 1;

            // 1. 각 기능 완료까지 걸리는 날짜 계산
            for (int i = 0; i < progresses.length; i++) {
                int currDay = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

                // 2. 배포 계산
                if (currDay <= prevDay)
                    count++;
                else {
                    result.add(count);
                    count = 1;
                    prevDay = currDay;
                }
            }
            result.add(count);

            return result.stream().mapToInt(i -> i).toArray();
        }
    }
}
