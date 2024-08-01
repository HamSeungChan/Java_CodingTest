import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        int top = -1;
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = array[i];
            if (top < tmp) {
                while (!stack.isEmpty()) {
                    answer += top - stack.pop();
                }
                top = tmp;
            } else {
                stack.push(tmp);
            }
        }

        while (!stack.isEmpty()) {
            answer += top - stack.pop();
        }

        System.out.println(answer);
    }
}