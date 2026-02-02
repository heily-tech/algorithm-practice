class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getArrayGCD(arrayA);
        int gcdB = getArrayGCD(arrayB);

        int candidateA = getCandidate(gcdA, arrayB);
        int candidateB = getCandidate(gcdB, arrayA);

        return Math.max(candidateA, candidateB);
    }

    private int getCandidate(int gcd, int[] opponent) {
        if (gcd == 1) return 0;
        for (int v : opponent)
            if (v % gcd == 0) return 0;
        
        return gcd;
    }

    private int getArrayGCD(int[] array) {
        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = getGCD(gcd, array[i]);
            if (gcd == 1) return 1;
        }
        return gcd;
    }

    private int getGCD(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}