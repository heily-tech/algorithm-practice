class Solution {
    public int[] solution(int brown, int yellow) {
        int vol = brown + yellow;
        int sqrt = (int) Math.sqrt(vol);

        // from 3 to sqrt(brown + yellow)
        for (int vert = 3; vert <= sqrt; vert++) {
            if (vol % vert == 0) {
                int horiz = (int) (vol / vert);
                // (width + height) * 2 - 4
                if (brown == (horiz + vert) * 2 - 4)
                    return new int[]{horiz, vert};
            }            
        }
        return new int[]{};
    }
}