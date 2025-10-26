import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int N = citations.length;
        
        for (int i = 0; i < N; i++) {
            int h = N - i;          // 남은 논문 수
            if (citations[i] >= h) 
                return h;
        }
        return 0;
    }
}
