import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        heapSort();

        for (int i = 0; i < N; i++)
            sb.append(arr[i]).append('\n');
        System.out.print(sb);
    }

    private static void heapSort() {
        for (int i = N / 2 - 1; i >= 0; i--) heapify(N, i);
       
        for (int i = N - 1; i > 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
    }

    private static void heapify(int heapSize, int root) {

        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < heapSize && arr[left] > arr[largest]) largest = left;
        if (right < heapSize && arr[right] > arr[largest]) largest = right;

        if (largest != root) {
            swap(root, largest);
            heapify(heapSize, largest);
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}