import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Score> q = new PriorityQueue<>(new Comparator<Score>() {
                @Override
                public int compare(Score o1, Score o2) {
                    return o1.a - o2.a;
                }
            });
            PriorityQueue<Score> q2 = new PriorityQueue<>(new Comparator<Score>() {
                @Override
                public int compare(Score o1, Score o2) {
                    return o1.b - o2.b;
                }
            });
            StringTokenizer token;
            for (int j = 0; j < n; j++) {
                token = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                q.add(new Score(a, b));
            }
            int minValue = Integer.MAX_VALUE;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Score tmp = q.poll();
                if (minValue > tmp.b) {
                    minValue = tmp.b;
                    q2.offer(tmp);
                }
            }
            minValue = Integer.MAX_VALUE;
            size = q2.size();
            int answer = 0;

            for (int i = 0; i < size; i++) {
                Score tmp = q2.poll();
                if (minValue > tmp.a) {
                    minValue = tmp.a;
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}

class Score {
    int a;
    int b;

    public Score(int a, int b) {
        this.a = a;
        this.b = b;
    }
}