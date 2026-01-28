import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] timeTable = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken()); // start
            timeTable[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        Arrays.sort(timeTable, Comparator.comparingInt((int[] a) -> a[1])
                                         .thenComparingInt(a -> a[0]));

        int endTime = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (timeTable[i][0] >= endTime) {
                endTime = timeTable[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}