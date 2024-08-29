import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringTokenizer token;

        int leftSum = 0;
        int rightSum = 0;

        Queue<Integer> leftQueue = new ArrayDeque<>();
        Queue<Integer> rightQueue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int questionNumber = Integer.parseInt(token.nextToken());

            if (questionNumber == 1) {
                int value = Integer.parseInt(token.nextToken());
                rightQueue.offer(value);
                rightSum += value;
            } else {

                if (leftSum > rightSum) {
                    sb.append(rightSum).append("\n");
                    rightSum = leftSum;
                    leftSum = 0;
                    rightQueue = leftQueue;
                    leftQueue = new ArrayDeque<>();
                } else {
                    sb.append(leftSum).append("\n");
                    leftSum = 0;
                    leftQueue.clear();
                }
            }

            while (leftQueue.isEmpty() || leftQueue.size() + 1 < rightQueue.size()) {
                int tmp = rightQueue.poll();
                leftQueue.offer(tmp);
                leftSum += tmp;
                rightSum -= tmp;
            }
        }

        while (!leftQueue.isEmpty()) {
            sb.append(leftQueue.poll()).append(" ");
        }

        while (!rightQueue.isEmpty()) {
            sb.append(rightQueue.poll()).append(" ");
        }
        System.out.println(sb);
    }
}