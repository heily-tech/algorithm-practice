import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        selectionSort(arr, k);
    }

    private static void selectionSort(int[] arr, int k) {
        int n = arr.length;

        HashMap<Integer, Integer> posMap = new HashMap<>(n * 2);
        for (int i = 0; i < n; i++) posMap.put(arr[i], i);
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        int cnt = 0;

        for (int i = n - 1; i >= 1; i--) {
            int value = sorted[i];
            int pos = posMap.get(value);

            if (pos == i)
                continue;

            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;

            posMap.put(arr[pos], pos);
            posMap.put(arr[i], i);

            if (++cnt == k) {
                StringBuilder sb = new StringBuilder();
                for (int num : arr) sb.append(num).append(' ');
                System.out.println(sb);
                return;
            }
        }

        System.out.println(-1);
    }
}