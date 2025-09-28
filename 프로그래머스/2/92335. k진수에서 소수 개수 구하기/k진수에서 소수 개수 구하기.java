import java.util.regex.*;

class Solution {
    public int solution(int n, int k) {
        String base = Long.toString(n, k); // k진수 변환
        int cnt = 0;
        
        // 패턴 찾기
        String[] parts = base.split("0+");
        
        // 소수 찾기
        for (String p : parts) {
            if (p.isEmpty())
                continue;
            long val = Long.parseLong(p);
            if (isPrime(val))
                cnt++;
        }
        
        return cnt;
    }
    
    private boolean isPrime(long x) {
        if (x < 2)
            return false;
        if (x % 2 == 0)
            return x == 2; 
        
        long r = (long) Math.sqrt(x);
        for (long d = 3; d <= r; d += 2)
            if (x % d == 0)
                return false;
        return true;
    }
}