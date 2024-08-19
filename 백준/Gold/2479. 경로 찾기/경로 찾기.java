import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, start, end;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] check;
    static boolean flag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        check = new int[n + 1];
        Arrays.fill(check, -1);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] array = new int[n + 1][k];
        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < k; j++) {
                array[i][j] = tmp.charAt(j) - '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int count = 0;
                for (int l = 0; l < k; l++) {
                    count += array[i][l] ^ array[j][l];
                }
                if (count == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        token = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(token.nextToken());
        end = Integer.parseInt(token.nextToken());

        sb.append(-1);
        check[start] = 0;
        dfs(start);
        System.out.println(sb);
    }

    public static void dfs(int now) {

        if (flag) {
            return;
        }

        if (now == end) {
            flag = true;
            sb = new StringBuilder();
            List<Integer> list = new ArrayList<>();
            int value = now;
            while (true) {
                list.add(value);
                value = check[value];
                if (value == 0) {
                    break;
                }
            }
            Collections.reverse(list);
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            return;
        }

        List<Integer> nextList = graph.get(now);
        for (Integer next : nextList) {
            if (check[next] == -1) {
                check[next] = now;
                dfs(next);
            }
        }
    }
}