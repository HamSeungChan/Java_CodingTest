import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node start = new Node("start");
        StringTokenizer token;
        for (int i = 0; i < n; i++) {

            Node nowNode = start;

            token = new StringTokenizer(br.readLine(), " ");
            int depth = Integer.parseInt(token.nextToken());

            // depth 들어간다
            for (int j = 0; j < depth; j++) {
                String now = token.nextToken();

                // 다음 depth가 이미 존재함
                if (nowNode.nextList.containsKey(now)) {
                    nowNode = nowNode.nextList.get(now);
                }

                // 다음 depth가 존재하지 않음
                else {
                    Node newNode = new Node(now);
                    nowNode.nextList.put(now, newNode);
                    nowNode = newNode;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        recursion(0, start, sb);
        System.out.print(sb);
    }

    public static void recursion(int depth, Node node, StringBuilder sb) {

        if (depth != 0) {
            for (int i = 0; i < depth - 1; i++) {
                sb.append("--");
            }
            sb.append(node.value);
            sb.append("\n");
        }

        Map<String, Node> nextList = node.nextList;

        List<String> keySet = new ArrayList<>(nextList.keySet());
        Collections.sort(keySet);
        for (String s : keySet) {
            recursion(depth + 1, nextList.get(s), sb);
        }
    }

}

class Node {
    String value;
    Map<String, Node> nextList = new HashMap<>();

    public Node(String value) {
        this.value = value;
    }
}