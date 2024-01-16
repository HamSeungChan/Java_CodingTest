import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> leftStack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        String[] s = br.readLine().split("");

        for (int i = 0; i < s.length; i++) {
            leftStack.push(s[i]);
        }
        int n = Integer.parseInt(br.readLine());

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            String cmd = token.nextToken();

            if (cmd.equals("P")) {
                String tmp = token.nextToken();
                leftStack.push(tmp);
            } else if (cmd.equals("L")) {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (cmd.equals("D")) {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!leftStack.isEmpty()) {
            sb.append(leftStack.pop());
        }

        sb.reverse();

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}