import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 1. 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 빈도 수 계산 (M 글자 이상)
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) 
                continue;
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // 3. 정렬
        List<Map.Entry<String, Integer>> sortedDict = getSortedDict(freq);

        // 4. 출력
        StringBuilder sb = new StringBuilder();
        sortedDict.forEach(e -> sb.append(e.getKey()).append('\n'));
        /* for (Map.Entry<String, Integer> e : sortedDict) 
                sb.append(e.getKey()).append('\n'); */
        System.out.print(sb);
    }

    private static List<Map.Entry<String, Integer>> getSortedDict(Map<String, Integer> freq) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());

        list.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue()); // 빈도
            if (cmp != 0) 
                return cmp;

            cmp = Integer.compare(b.getKey().length(), a.getKey().length()); // 길이
            if (cmp != 0) 
                return cmp;

            return a.getKey().compareTo(b.getKey()); // 사전순
        });

        return list;
    }

}
