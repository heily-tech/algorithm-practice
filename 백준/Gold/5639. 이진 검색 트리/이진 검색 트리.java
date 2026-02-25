import java.io.*;
import java.util.*;

public class Main {
    static int[] pre;
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();

    // bound 보다 큰 값이 나오면 현재 서브트리 종료
    static void buildPost(int bound) {
        if (idx == pre.length) return;
        int val = pre[idx];
        if (val > bound) return;

        idx++;

        // 왼쪽: val 보다 작은 값들만 들어올 수 있으니 bound = val
        buildPost(val);

        // 오른쪽: bound는 그대로 유지 (현재 서브트리의 상한)
        buildPost(bound);

        sb.append(val).append('\n');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;
            list.add(Integer.parseInt(s));
        }

        pre = new int[list.size()];
        for (int i = 0; i < list.size(); i++) pre[i] = list.get(i);

        buildPost(Integer.MAX_VALUE);

        System.out.print(sb);
    }
}