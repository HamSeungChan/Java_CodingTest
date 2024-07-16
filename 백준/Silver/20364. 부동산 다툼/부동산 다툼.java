import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, q;
    static int[] check;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        // 땅의 갯수
        n = Integer.parseInt(token.nextToken());
        // 오리의 수
        q = Integer.parseInt(token.nextToken());

        // 점유 정보를 저장하는 boolean 배열
        check = new int[n + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {

            int tmp = Integer.parseInt(br.readLine());
            if (check[tmp] == 0) {
                sb.append(0).append("\n");
                check[tmp] = tmp;
                dfs(tmp, tmp);
            } else {
                sb.append(check[tmp]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static void dfs(int now, int value) {

        int a = now * 2;
        int b = now * 2 + 1;

        if (a <= n) {
            check[a] = value;
            dfs(a, value);
        }

        if (b <= n) {
            check[b] = value;
            dfs(b, value);
        }
    }


}