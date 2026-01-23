import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /* 트리를 구성할 기본 정보 */
    static class Node {
        int data;
        Node left_child;
        Node right_child;

        private Node(int data) {
            this.data = data;
        }

        private void insert(int x) {
            if (x < this.data) {
                if (this.left_child == null)
                    this.left_child = new Node(x);
                else
                    this.left_child.insert(x);
            } else {
                if (this.right_child == null)
                    this.right_child = new Node(x);
                else
                    this.right_child.insert(x);
            }
        }
    }

    private static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left_child);
            postOrder(node.right_child);
            System.out.printf("%d\n", node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(bufferedReader.readLine()));

        /* 전위 순회 정보를 이용하여 트리 그리기 */
        while (true) {
            String s = bufferedReader.readLine();
            if (s == null || s.equals(""))
                break;
            int data = Integer.parseInt(s);
            root.insert(data);
        }

        /* 그려진 트리를 후위 순회하기 */
        postOrder(root);
    }
}
