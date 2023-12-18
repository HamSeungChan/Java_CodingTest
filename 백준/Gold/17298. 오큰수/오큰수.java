import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        Arrays.fill(answer, -1);


        Stack<Info> stack = new Stack<>();
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(token.nextToken());

            if (stack.isEmpty()) {
                stack.push(new Info(i, value));
                continue;
            }

            while (true) {

                if (stack.peek().value < value) {
                    Info tmp = stack.pop();
                    answer[tmp.index] = value;

                    if (stack.isEmpty()) {
                        stack.push(new Info(i, value));
                        break;
                    }

                } else {
                    stack.push(new Info(i, value));
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);

    }
}

class Info {
    int index;
    int value;

    public Info(int index, int value) {
        this.index = index;
        this.value = value;
    }
}