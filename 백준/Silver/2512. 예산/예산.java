import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 1. 값 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] requests = new int[N];
        int totalRequest = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            totalRequest += requests[i];
        }
        int totalBudget = Integer.parseInt(br.readLine());
        
        // 2. 예산 배정 계산
        if (totalRequest <= totalBudget)
            System.out.println(getMaxRequest(requests));
        else
            System.out.println(getCappedBudget(requests, totalBudget));
    }
    
    private static int getMaxRequest(int[] requests) {
        int maxBudget = 0;
        for (int r : requests)
            maxBudget = Math.max(maxBudget, r);
        return maxBudget;
    }
    
    private static int getCappedBudget(int[] requests, int totalBudget) {
        int left = 0, right = getMaxRequest(requests);
        int cap = 0;
        
        // Binary Search
        while (left <= right) {
            int mid = (left + right) / 2;    // 배정 예정 금액
            int sum = 0;
            
            for (int r : requests)
                sum += Math.min(r, mid);
            
            if (sum <= totalBudget) {
                cap = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return cap;
    }
}