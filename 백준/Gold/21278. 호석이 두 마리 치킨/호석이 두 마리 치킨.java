import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int answer = 100001;
    static int a, b;


    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[][] dist = new int[n][n];
        for (int[] d : dist) {
            Arrays.fill(d, 100001);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(in.readLine(), " ");
            int a = Integer.parseInt(token.nextToken()) - 1;
            int b = Integer.parseInt(token.nextToken()) - 1;
            dist[a][b] = 2;
            dist[b][a] = 2;
        }


        allDist(n, dist);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] chicken = {i, j};
                reDist(chicken, n, dist);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" ").append(b).append(" ").append(answer);
        System.out.println(sb);
    }


    private static void reDist(int[] chicken, int N, int[][] dist) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 2; j++) {
                int tmp = chicken[j];
                min = Math.min(min, dist[i][tmp]);
            }
            sum += min;
        }
        if (sum < answer) {
            answer = sum;
            a = chicken[0] + 1;
            b = chicken[1] + 1;
        }
    }


    private static void allDist(int n, int[][] dist) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}