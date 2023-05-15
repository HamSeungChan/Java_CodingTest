import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        List<int[][]> list = new ArrayList<>();


        for (int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int mid = n / 2;
            int[][] graph = new int[n][n];

            int[] diagonal = new int[n];
            int[] reverseDiagonal = new int[n];
            int[] column = new int[n];
            int[] row = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (i == j) {
                        diagonal[i] = tmp;
                    }
                    if (i + j == n - 1) {
                        reverseDiagonal[i] = tmp;
                    }
                    if (j == mid) {
                        column[i] = tmp;
                    }
                    if (i == mid) {
                        row[j] = tmp;
                    }
                    graph[i][j] = tmp;
                }
            }

            int tryCount = d / 45;
            if (tryCount < 0) {
                for (int i = 0; i < Math.abs(tryCount); i++) {
                    int[] tmp = column;
                    column = reverseDiagonal;
                    int[]tmp2 = new int[n];
                    for(int j =0; j< reverseDiagonal.length; j++) {
                        tmp2[j] = row[reverseDiagonal.length-1-j];
                    }
                    reverseDiagonal = tmp2;
                    row = diagonal;
                    diagonal = tmp;
                }
            } else {
                for (int i = 0; i < tryCount; i++) {
                    int[] tmp = column;
                    column = diagonal;
                    diagonal = row;
                    int[]tmp2 = new int[n];
                    for(int j =0; j< row.length; j++) {
                        tmp2[j] = reverseDiagonal[diagonal.length-1-j];
                    }
                    row = tmp2;
                    reverseDiagonal = tmp;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        graph[i][j] = diagonal[i];
                    }
                    if (i + j == n - 1) {
                        graph[i][j] = reverseDiagonal[i];
                    }
                    if (j == mid) {
                        graph[i][j] = column[i];
                    }
                    if (i == mid) {
                        graph[i][j] = row[j];
                    }
                }
            }
            list.add(graph);
        }
        for(int[][] graph : list){
            for(int i=0; i<graph.length;i++){
                for(int j =0; j<graph[0].length; j++){
                    System.out.print(graph[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
