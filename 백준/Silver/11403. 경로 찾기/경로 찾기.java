import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] graph = new int[n][n];
        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (BFS(i, j, graph)) {
                    answer[i][j] = 1;
                }
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean BFS(int i, int j, int[][] graph) {
        int[][] check = new int[n][n];
        Queue<Integer> q = new LinkedList<>();
        for (int k = 0; k < n; k++) {
            if (graph[i][k] == 1) {
                q.offer(k);
                check[i][k] = 1;
            }
        }
        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp == j) return true;
            for(int k =0; k< n; k++){
                if(graph[tmp][k] == 1 && check[tmp][k] ==0){
                    q.offer(k);
                    check[tmp][k] = 1;
                }
            }
        }
        return false;
    }
}
