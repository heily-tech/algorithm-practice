import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 2. 수 정렬하기 (퀵 정렬)
        Arrays.sort(numbers);

        // 3. 정렬된 수 출력하기
        for (int i : numbers) {
            System.out.println(i);
        }
    }
}
