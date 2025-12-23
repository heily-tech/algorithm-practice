import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];

            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                price[j] = Integer.parseInt(token.nextToken());

            System.out.println(getMaxProfit(price));
        }
    }

    private static long getMaxProfit(int[] price) {
        long profit = 0;    // 부호 있는 64형 정수
        int maxPrice = 0;

        for (int i = price.length - 1; i >= 0; i--)
            if (price[i] > maxPrice)
                maxPrice = price[i];
            else
                profit += (maxPrice - price[i]);

        return profit;
    }

}