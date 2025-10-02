import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int b = 0;
        for (int a : A) {
            while (b < B.length && B[b] <= a)
                b++;
            if (b == B.length)
                break;
            answer++;
            b++;
        }
        return answer;
    }
}