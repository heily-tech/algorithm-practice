import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        insertionSort(arr, t);
    }

    private static void insertionSort(int[] arr, int t) {
        long[] keys = new long[t];
        for (int i = 0; i < t; i++)
            keys[i] = ((long) arr[i]) << 32 | (i & 0xffffffffL);

        Arrays.sort(keys);

        for (int i = 0; i < t; i++)
            arr[i] = (int) (keys[i] >>> 32);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i + 1 < arr.length)
                sb.append(' ');
        }
        System.out.print(sb);
    }
}