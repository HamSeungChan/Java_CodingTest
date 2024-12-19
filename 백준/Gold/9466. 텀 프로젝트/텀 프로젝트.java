import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] next;
    static boolean[] check;
    static boolean[] cycle;
    static int totalCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());

            token = new StringTokenizer(br.readLine(), " ");
            next = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                next[j] = Integer.parseInt(token.nextToken());
            }

            check = new boolean[n + 1];
            cycle = new boolean[n + 1];
            totalCount = 0;

            for (int j = 1; j <= n; j++) {
                if (!cycle[j]) {
                    dfs(j);
                }
            }

            sb.append(n - totalCount).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int now) {

        if (cycle[now]) {
            return;
        }

        if (check[now]) {
            totalCount++;
            cycle[now] = true;
        }

        check[now] = true;
        dfs(next[now]);

        cycle[now] = true;
    }
}