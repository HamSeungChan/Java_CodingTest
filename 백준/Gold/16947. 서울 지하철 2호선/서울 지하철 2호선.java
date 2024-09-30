import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> list;
    static boolean[] check;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 사이클 여부를 확인하는 배열
        check = new boolean[n + 1];

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (checkCycle(i, 0, i)) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(bfs(i)).append(" ");
        }
        System.out.print(sb);
    }

    public static int bfs(int value) {

        int distance = 0;
        boolean[] isVisit = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(value);
        isVisit[value] = true;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (check[now]) {
                    return distance;
                }

                for (int next : list.get(now)) {
                    if (!isVisit[next]) {
                        q.add(next);
                        isVisit[next] = true;
                    }
                }
            }
            distance++;
        }

        return distance;
    }

    public static boolean checkCycle(int start, int prev, int now) {

        check[now] = true;

        for (Integer next : list.get(now)) {

            if (next == prev) {
                continue;
            }

            if (!check[next]) {
                if (checkCycle(start, now, next)) {
                    return true;
                }
            } else if (start == next) {
                return true;
            }
        }

        check[now] = false;

        return false;
    }

}