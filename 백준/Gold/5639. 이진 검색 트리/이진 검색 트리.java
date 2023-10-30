import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        void insert(int input) {
            if (this.value > input) {
                if (left == null) {
                    left = new Node(input);
                } else {
                    left.insert(input);
                }
            } else {
                if (right == null) {
                    right = new Node(input);
                } else {
                    right.insert(input);
                }
            }
        }
    }

    static void postOrder(Node node) {
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.parseInt(br.readLine());
        Node node = new Node(value);
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.isEmpty()) break;
            value = Integer.parseInt(input);
            node.insert(value);
        }
        postOrder(node);
        System.out.print(sb);
    }
}