import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        long sum = 0;
        int ans = n + 1;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum >= s) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left++];
            }
        }

        System.out.println(ans == n + 1 ? 0 : ans);
    }
}
