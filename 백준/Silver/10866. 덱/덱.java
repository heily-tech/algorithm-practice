import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x;

            switch (command) {
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    deque.offerFirst(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    deque.offerLast(x);
                    break;
                case "pop_front":
                    if (deque.isEmpty())
                        builder.append(-1).append('\n');
                    else
                        builder.append(deque.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if (deque.isEmpty())
                        builder.append(-1).append('\n');
                    else
                        builder.append(deque.pollLast()).append('\n');
                    break;
                case "size":
                    builder.append(deque.size()).append('\n');
                    break;
                case "empty":
                    builder.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    if (deque.isEmpty())
                        builder.append(-1).append('\n');
                    else
                        builder.append(deque.peekFirst()).append('\n');
                    break;
                case "back":
                    if (deque.isEmpty())
                        builder.append(-1).append('\n');
                    else
                        builder.append(deque.peekLast()).append('\n');
                    break;
            }
        }

        System.out.println(builder);
    }
}