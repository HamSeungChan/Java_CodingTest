import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        String[] tmp = br.readLine().split("");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tmp[i]);
        }

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);

        boolean flag = false;
        for (int i = 1; i < n; i++) {

            if (!flag) {
                while (!stack.isEmpty() && stack.peek() < array[i]) {
                    stack.pop();
                    count++;

                    if (count == k) {
                        flag = true;
                        break;
                    }
                }
            }
            stack.push(array[i]);
        }

        while (count != k) {
            stack.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}