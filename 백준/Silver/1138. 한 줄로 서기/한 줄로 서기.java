import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int[] line = new int[N];

        for (int curr = 1; curr <= N; curr++) {
            int left = Integer.parseInt(tokenizer.nextToken());

            for (int pos = 0; pos < N; pos++) {
                // 내 앞의 비어있는 칸은 나보다 큰 사람들의 자리
                if (line[pos] == 0) {
                    if (left == 0) {
                        line[pos] = curr;
                        break;
                    }
                    left--;
                }
            }
        }
        System.out.println(getString(line));
    }

    private static String getString(int[] line) {
        return Arrays.stream(line)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}