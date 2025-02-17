import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Node> map = new HashMap<>();

        Node root = new Node("A");
        map.put("A", root);

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");

            String parent = split[0];

            Node node = map.get(parent);

            String leftTmp = split[1];
            String rightTmp = split[2];

            if (!leftTmp.equals(".")) {
                Node left = new Node(split[1]);
                map.put(split[1], left);
                node.setLeftNode(left);
            }

            if (!rightTmp.equals(".")) {
                Node right = new Node(split[2]);
                map.put(split[2], right);
                node.setRightNode(right);
            }
        }

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.append("\n");

        inorder(root, sb);
        sb.append("\n");

        postorder(root, sb);
        System.out.print(sb);
    }

    public static void preorder(Node parent, StringBuilder sb) {

        if (parent == null) {
            return;
        }

        sb.append(parent.tmp);
        preorder(parent.leftNode, sb);
        preorder(parent.rightNode, sb);

    }

    public static void inorder(Node parent, StringBuilder sb) {

        if (parent == null) {
            return;
        }

        inorder(parent.leftNode, sb);
        sb.append(parent.tmp);
        inorder(parent.rightNode, sb);
    }

    public static void postorder(Node parent, StringBuilder sb) {

        if (parent == null) {
            return;
        }

        postorder(parent.leftNode, sb);
        postorder(parent.rightNode, sb);
        sb.append(parent.tmp);

    }

}

class Node {

    String tmp;
    Node leftNode;
    Node rightNode;

    public Node(String tmp) {
        this.tmp = tmp;
    }

    public void setLeftNode(Node node) {
        leftNode = node;
    }

    public void setRightNode(Node node) {
        rightNode = node;
    }
}