import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer token;
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            token = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                answer += 1;
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
            }
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (pop != 0) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}