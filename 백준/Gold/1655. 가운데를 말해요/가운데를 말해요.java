import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();

        int midValue = Integer.parseInt(br.readLine());
        sb.append(midValue).append("\n");
        for (int i = 1; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (i % 2 == 1) {           // 현재 숫자의 갯수가 홀수일 때
                if (midValue > value) {   // 더 작은 수가 들어오면
                    leftQ.offer(value); // 우선 왼쪽 큐에 넣는다.
                    rightQ.offer(midValue);     // 현재 값을 오른 쪽 큐에 넣고
                    midValue = leftQ.poll();   // midValue를 갱신한다.
                } else {
                    rightQ.offer(value); // 더 큰 수가 들어오면 오른 쪽 큐에 넣는다.
                }
            } else {           // 짝수 일때
                if (midValue < value) {
                    rightQ.offer(value);
                    leftQ.offer(midValue);
                    midValue = rightQ.poll();
                } else {
                    leftQ.offer(value);
                }
            }

            sb.append(midValue).append("\n");
        }

        System.out.print(sb);
    }
}