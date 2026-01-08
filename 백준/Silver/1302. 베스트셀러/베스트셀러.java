import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> bookSell = new HashMap<>((int)(N / 0.75f) + 1);

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            bookSell.put(key, bookSell.getOrDefault(key, 0) + 1);
        }

        String bestSeller = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : bookSell.entrySet()) {
            if (max < entry.getValue() || (entry.getValue() == max && (bestSeller == null || entry.getKey().compareTo(bestSeller) < 0))) {
                max = entry.getValue();
                bestSeller = entry.getKey();
            }
        }

        System.out.println(bestSeller);
    }
}