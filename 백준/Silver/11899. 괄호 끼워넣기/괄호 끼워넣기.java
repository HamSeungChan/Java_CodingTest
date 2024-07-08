import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (char c : array) {
            if (c == ')') {

                if (stack.isEmpty()) {
                    answer++;
                    continue;
                }
                stack.pop();

            } else {
                stack.push('(');
            }
        }
        System.out.println(answer + stack.size());
    }
}