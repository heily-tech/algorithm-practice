import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        insertionSort(arr, K);
    }

    private static void insertionSort(int[] arr, int K) {
        int cnt = 0;

        for (int i = 1; i < arr.length; i++) {
            int newItem = arr[i];
            int curr = i - 1;

            while (curr >= 0 && newItem < arr[curr]) {
                int saved = arr[curr];
                arr[curr + 1] = saved;
                if (++cnt == K) {
                    System.out.println(saved);
                    return;
                }
                curr--;
            }

            if (curr + 1 != i) {
                arr[curr + 1] = newItem;
                if (++cnt == K) {
                    System.out.println(newItem);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}