import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Tree {

    public Node root;

    public void createNode(char data, char leftData, char rightData) {

        if (root == null) {
            root = new Node(data);
            root.left = leftData != '.' ? new Node(leftData) : null;
            root.right = rightData != '.' ? new Node(rightData) : null;
        } else {
            searchNode(root, data, leftData, rightData);
        }

    }

    public void searchNode(Node node, char data, char leftData, char rightData) {

        if (node == null) {
            return;
        } else if (node.data == data) {
            node.left = leftData != '.' ? new Node(leftData) : null;
            node.right = rightData != '.' ? new Node(rightData) : null;
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

}

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree t = new Tree();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            char data = token.nextToken().charAt(0);
            char leftData = token.nextToken().charAt(0);
            char rightData = token.nextToken().charAt(0);

            t.createNode(data, leftData, rightData);
        }

        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
    }
}