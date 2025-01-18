import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] next;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());
            check = new boolean[n + 1];
            next = new int[n + 1];
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                next[j] = Integer.parseInt(token.nextToken());
            }

            int answer = 0;
            for (int j = 1; j <= n; j++) {
                if (!check[j]) {
                    check[j] = true;
                    dfs(j);
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int now) {

        int nextNode = next[now];
        if (!check[nextNode]) {
            check[nextNode] = true;
            dfs(nextNode);
        }
    }
}