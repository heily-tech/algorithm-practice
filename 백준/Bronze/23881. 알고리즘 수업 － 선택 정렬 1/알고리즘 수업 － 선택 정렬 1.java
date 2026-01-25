import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int cnt = 0;

        for (int i = n - 1; i >= 1; i--) {
            int maxPos = 0;
            for (int j = 1; j <= i; j++)
                if (arr[j] > arr[maxPos]) maxPos = j;

            if (maxPos == i)
                continue;

            if (++cnt == k) {
                if (arr[i] < arr[maxPos]) System.out.println(arr[i] + " " + arr[maxPos]);
                else System.out.println(arr[maxPos] + " " + arr[i]);
                return;
            }
            int temp = arr[i];
            arr[i] = arr[maxPos];
            arr[maxPos] = temp;
        }

        System.out.println(-1);
    }
}