import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int p = Integer.parseInt(token.nextToken());

        int answer = 0;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            // a 줄을 눌렀는지 확인
            if (!map.containsKey(a)) {
                Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                answer++;
                pq.add(b);
                map.put(a, pq);
            } else {
                Queue<Integer> pq = map.get(a);
                while (!pq.isEmpty()) {
                    if (pq.peek() < b) {
                        pq.add(b);
                        answer++;
                        break;
                    } else if (pq.peek() == b) {
                        break;
                    } else {
                        pq.poll();
                        answer++;
                    }
                }

                if (pq.isEmpty()) {
                    pq.add(b);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
