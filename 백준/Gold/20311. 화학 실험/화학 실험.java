import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가장 많은 수의 크기가 절반보다 작아야 한다.

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
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int count = Integer.parseInt(token.nextToken());
            list.add(new Info(i + 1, count));
        }

        solution(k, n, list);
    }


    public static void solution(int k, int n, List<Info> list) {

        Collections.sort(list, (o1, o2) -> Integer.compare(o2.count, o1.count));
        if (list.get(0).count > (n + 1) / 2) {
            System.out.println(-1);
            return;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (Info info : list) {
            for (int i = 0; i < info.count; i++) {
                deque.addLast(info.value);
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i += 2) {
            answer[i] = deque.pollFirst();
        }

        for (int i = 1; i < n; i += 2) {
            answer[i] = deque.pollFirst();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
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
