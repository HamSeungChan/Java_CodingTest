import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        // 시험관의 개수
        int n = Integer.parseInt(token.nextToken());
        // 색깔의 종류
        int k = Integer.parseInt(token.nextToken());

        // 색깔의 시약이 담긴 시험관의 개수
        token = new StringTokenizer(br.readLine(), " ");
        Queue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            int count = Integer.parseInt(token.nextToken());
            pq.add(new Info(i + 1, count));
        }

        solution(k, n, pq);
    }


    public static void solution(int k, int n, Queue<Info> pq) {

        int[] answer = new int[n + 1];
        List<Info> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            Info poll = pq.poll();

            // 이전 값과 같다면
            if (answer[i - 1] == poll.value) {
                System.out.println(-1);
                return;
            }

            answer[i] = poll.value;
//            for (int j = 1; j <= n; j++) {
//                System.out.print(answer[j]+" ");
//            }
//            System.out.println();

            if (--poll.count == 0) {
                pq.addAll(list);
                list.clear();
                continue;
            }

            list.add(poll);

            if (pq.isEmpty()) {
                pq.addAll(list);
                list.clear();
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb);
    }
}

class Info implements Comparable<Info> {

    int value;
    int count;

    public Info(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(Info o) {
        return o.count - this.count;
    }
}
