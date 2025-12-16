import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        // 키워드 개수 N _ 블로그 글 개수 M
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        // 키워드 N개
        HashSet<String> memo = new HashSet<>();
        for (int i = 0; i < N; i++)
            memo.add(br.readLine());

        // 글 M개
        for (int i = 0; i < M; i++) {
            String[] strings = br.readLine().split(",");
            for (String string : strings)
                memo.remove(string);
            
            System.out.println(memo.size());
        }
    }
}