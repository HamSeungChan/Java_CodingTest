import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(token.nextToken());
        int w = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine(), " ");

        Stack<Integer> stack = new Stack<>();
        int topValue = 0;
        int answer = 0;

        for (int i = 0; i < w; i++) {
            int value = Integer.parseInt(token.nextToken());

            if (stack.isEmpty()) {
                topValue = value;
                stack.push(value);
                continue;
            } else if (topValue <= value) {
                while (stack.peek() != topValue) {
                    answer += topValue - stack.pop();
                }
                stack.pop();
                stack.push(value);
                topValue = value;
            } else {
                stack.push(value);
            }
        }

        int lastValue = stack.pop();

        if (!stack.isEmpty()) {
            while (stack.peek() != topValue) {
                int value = stack.pop();
                if (lastValue > value) {
                    answer += lastValue - value;
                } else {
                    lastValue = value;
                }
            }
        }


        System.out.println(answer);


    }
}