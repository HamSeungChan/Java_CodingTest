import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        char[] tmp = br.readLine().toCharArray();
        int beforeLength = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {

            if (tmp[i] == '(') {
                stack.push(0);
                continue;
            }

            if (stack.isEmpty()) {
                continue;
            }

            int value = stack.pop();
            beforeLength = 0;
            boolean flag = false;
            if (value > 0) {

                while (value != 0) {
                    beforeLength += value;
                    if (stack.isEmpty() || stack.peek() == -1) {
                        stack.push(beforeLength);
                        stack.push(-1);
                        flag = true;
                        break;
                    }
                    value = stack.pop();
                }
                if (flag) {
                    continue;
                }
                stack.push(beforeLength + 2);
            } else if (value == 0) {
                stack.push(2);
            } else if (value == -1) {
                stack.push(-1);
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            int value = stack.pop();
//            System.out.println(value);

            if (value == 0 || value == -1) {
                total = 0;
                continue;
            }
            total += value;
            answer = Math.max(total, answer);
        }

        System.out.println(answer);
    }
}
