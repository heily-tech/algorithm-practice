class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;

        int left = 0;
        long sum = 0;

        int bestL = 0, bestR = 0;
        int bestLen = n + 1;
        for (int right = 0; right < n; right++) {
            sum += sequence[right];

            while (left <= right && sum > k) sum -= sequence[left++];

            if (sum == k) {
                int len = right - left;
                if (len < bestLen || (len == bestLen && left < bestL)) {
                    bestLen = len;
                    bestL = left;
                    bestR = right;
                }
            }
        }

        return new int[]{bestL, bestR};
    }
}