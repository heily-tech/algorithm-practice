import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());

        // 길이가 N인 수열
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());

        // 최정 연속 부분 수열의 길이 출력
        System.out.println(findSubarray(arr, N, K));
    }

    private static int findSubarray(int[] arr, int N, int K) {
        int[] cnt = new int[100_001];   // 1-base (1 <= a_ <= 100,000)
        int le = 0;
        int max = 0;

        for (int ri = 0; ri < N; ri++) {
            cnt[arr[ri]]++;

            // K 개수 조건 만족하면 윈도우 범위 축소
            while (cnt[arr[ri]] > K) {
                cnt[arr[le]]--;
                le++;
            }
            max = Math.max(max, ri - le + 1);
        }

        return max;
    }
}