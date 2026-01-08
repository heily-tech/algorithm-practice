import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cards = new HashMap((int) (N / 0.75f) + 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            cards.put(num, cards.getOrDefault(num, 0) + 1);
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            num = Integer.parseInt(st.nextToken());
            builder.append(cards.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(builder.toString().trim());
    }
}