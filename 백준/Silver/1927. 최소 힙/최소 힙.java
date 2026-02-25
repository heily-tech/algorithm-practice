import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static int[] heap;
    private static int size = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        heap = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (size == 0) sb.append(0).append('\n');
                else sb.append(deleteMin()).append('\n');
            }
            else insert(x);
        }

        System.out.print(sb);
    }

    private static void insert(int x) {
        heap[++size] = x;
        int idx = size;

        while (idx > 1 && heap[idx] < heap[idx / 2]) {
            swap(idx, idx / 2);
            idx /= 2;
        }
    }

    private static int deleteMin() {
        int min = heap[1];
        heap[1] = heap[size--];

        int idx = 1;
        while (idx * 2 <= size) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int smaller = left;

            if (right <= size && heap[right] < heap[left]) smaller = right;

            if (heap[idx] <= heap[smaller]) break;

            swap(idx, smaller);
            idx = smaller;
        }

        return min;
    }

    static void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}