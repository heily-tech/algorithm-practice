class Solution {
    public int solution(String word) {
        // 5진수 체계 사용
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int[] weight = {781, 156, 31, 6, 1}; // 5*w_{k+1} + 1
        int answer = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int idx = "AEIOU".indexOf(word.charAt(i));
            answer += idx * weight[i] + 1;
        }
        return answer;
    }
}