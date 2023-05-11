import java.util.Scanner;

public class Main {

    static int[][] graph;
    static int n;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        check = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if(check[i] ==0) {
                answer++;
                new Main().DFS(i);
            }
        }
        System.out.println(answer);
    }

    public void DFS(int u) {

        if(check[u]==1) return;

        check[u] = 1;

        for (int i = 1; i <= n; i++) {
            if (graph[u][i] == 1) {
                DFS(i);
            }
        }
    }
}
