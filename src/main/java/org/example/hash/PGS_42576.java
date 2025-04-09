import java.util.HashMap;
import java.util.Map;

/*
 * 메모리 85000KB
 * 시간 34ms
 */

public class PGS_42576 {
    public static void main(String[] args) {
        // 1. 입력 데이터 설정
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        // 2. Solution 객체 생성
        Solution sol = new Solution();
        String result = sol.solution(participant, completion);

        // 3. 결과 출력
        System.out.println(result);
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            // 1. HashMap 정의
            Map<String, Integer> nonFinisher = new HashMap<>();

            // 2. 참가자 구성
            for (int i = 0; i < participant.length; i++)
                nonFinisher.put(participant[i], nonFinisher.getOrDefault(participant[i], 0) + 1);

            // 3. 완주자 검사
            for (int i = 0; i < completion.length; i++)
                if (nonFinisher.get(completion[i]) == 1)
                    nonFinisher.remove(completion[i]);
                else
                    nonFinisher.put(completion[i], nonFinisher.get(completion[i]) - 1);

            // 4. 결과 출력
            return nonFinisher.keySet().iterator().next();
        }
    }
}
