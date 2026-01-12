
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2. 스택 구현 (ArrayDeque)
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            switch (command.split(" ")[0]) {
                case "push":
                    stack.push(Integer.parseInt(command.split(" ")[1]));
                    break;
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
                default:
                    System.out.println("Invalid Command !");
            }
        }
    }
}
