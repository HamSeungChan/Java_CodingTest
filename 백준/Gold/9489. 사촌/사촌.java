import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        while (true) {
            token = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(token.nextToken());
            int k = Integer.parseInt(token.nextToken());

            if (n == 0 && k == 0) {
                break;
            }

            token = new StringTokenizer(br.readLine(), " ");
            Node[] node = new Node[n];
            int beforeValue = -1;
            int parentIndex = -1;

            for (int i = 0; i < n; i++) {

                int value = Integer.parseInt(token.nextToken());
                // 첫 번째
                if (i == 0) {
                    node[i] = new Node(null, value, new ArrayList<>());
                    continue;
                }

                // 연속된 값이 아니라면
                if (beforeValue + 1 != value) {
                    parentIndex++;
                }


                Node parents = node[parentIndex];
                node[i] = new Node(parents, value, new ArrayList<>());
                parents.childList.add(node[i]);

                beforeValue = value;
            }

            for (int i = 0; i < n; i++) {
                if (node[i].value == k) {

                    // 부모의 부모를 찾는다.
                    if (node[i].parent == null) {
                        sb.append(0).append("\n");
                        break;
                    }

                    Node parentsParent = node[i].parent.parent;

                    if (parentsParent == null) {
                        sb.append(0).append("\n");
                        break;
                    }

                    int count = 0;
                    // 부모의 부모의 자식의 자식 수를 확인한다.
                    for (Node child : parentsParent.childList) {
                        count += child.childList.size();
                    }
                    sb.append(count - node[i].parent.childList.size()).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

class Node {

    Node parent;
    int value;
    List<Node> childList;

    public Node(Node parent, int value, List<Node> childList) {
        this.parent = parent;
        this.value = value;
        this.childList = childList;
    }
}
