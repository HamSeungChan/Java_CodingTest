import java.util.*;

public class Main {

    static int numberOfNode;
    static int numberOfLine;
    static int startNode;
    static int[][] graph;
    static int[] dfsCheckNode;
    static int[] bfsCheckNode;
    static List<Integer> dfsNumberList = new ArrayList<>();
    static List<Integer> bfsNumberList = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        numberOfNode = sc.nextInt();
        numberOfLine = sc.nextInt();
        startNode = sc.nextInt();

        bfsCheckNode = new int[numberOfNode + 1];
        dfsCheckNode = new int[numberOfNode + 1];

        graph = new int[numberOfNode + 1][numberOfNode + 1];

        for (int i = 0; i < numberOfLine; i++) {

            int dotA = sc.nextInt();
            int dotB = sc.nextInt();

            graph[dotA][dotB] = 1;
            graph[dotB][dotA] = 1;

        }

        new Main().DFS(startNode);
        for (int i : dfsNumberList) {
            System.out.print(i + " ");
        }
        System.out.println();
        new Main().BFS(startNode);
        for (int i : bfsNumberList) {
            System.out.print(i + " ");
        }

    }

    public void DFS(int n) {


        bfsCheckNode[n] = 1;
        dfsNumberList.add(n);

        for (int i = 1; i <= numberOfNode; i++) {
            if (graph[n][i] == 1 && bfsCheckNode[i] == 0) {
                DFS(i);
            }
        }
    }


    public void BFS(int n) {
        q.add(n);
        dfsCheckNode[n] = 1;

        while (!q.isEmpty()) {
            int start = q.poll();
            bfsNumberList.add(start);
            for (int i = 1; i <= numberOfNode; i++) {
                if (graph[start][i] == 1 && dfsCheckNode[i] == 0) {
                    q.add(i);
                    dfsCheckNode[i] = 1;
                }
            }

        }
    }
}
