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
            int n = progresses.length;
            int[] days = new int[n];

            // 1. 각 기능 완료까지 걸리는 날짜 계산
            for (int i = 0; i < n; i++) {
                int remaining = 100 - progresses[i];
                days[i] = (remaining + speeds[i] - 1) / speeds[i];
            }

            // 2. 배포 계산
            List<Integer> answer = new ArrayList<>();
            int prevDay = days[0];
            int count = 1;

            for (int i = 1; i < n; i++) {
                // 남은 날짜가 이전 날짜보다 작으면 이전 기능과 함께 배포
                if (days[i] <= prevDay)
                    count++;
                else {
                    // 따로 배포
                    answer.add(count);
                    count = 1;
                    prevDay = days[i];
                }
            }
            answer.add(count);

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
