import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {

            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }

            if (check(s.split(""))) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean check(String[] s) {
        Stack<String> stack = new Stack<>();
        for (String tmp : s) {

            if (tmp.equals("(") || tmp.equals("[")) {
                stack.push(tmp);
            } else if (tmp.equals(")")) {
                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    return false;
                }
                stack.pop();
            } else if (tmp.equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}