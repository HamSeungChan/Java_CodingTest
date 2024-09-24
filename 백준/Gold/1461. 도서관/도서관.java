import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine(), " ");

        Queue<Integer> left = new PriorityQueue<>();
        Queue<Integer> right = new PriorityQueue<>(Collections.reverseOrder());
        int leftLong = 0;
        int rightLong = 0;

        for (int i = 0; i < n; i++) {

            int value = Integer.parseInt(token.nextToken());

            if (value < 0) {
                left.add(value);
                leftLong = Math.min(leftLong, value);
                continue;
            }

            right.add(value);
            rightLong = Math.max(rightLong, value);
        }


        int answer = 0;
        while (!left.isEmpty()) {
            int now = left.poll();
            for (int i = 0; i < m - 1; i++) {
                left.poll();
                if (left.isEmpty()) {
                    break;
                }
            }
            answer += Math.abs(now) * 2;
        }

        while (!right.isEmpty()) {
            int now = right.poll();
            for (int i = 0; i < m - 1; i++) {
                right.poll();
                if (right.isEmpty()) {
                    break;
                }
            }
            answer += now * 2;
        }

        System.out.println(answer - Math.max(Math.abs(leftLong), Math.abs(rightLong)));
    }
}