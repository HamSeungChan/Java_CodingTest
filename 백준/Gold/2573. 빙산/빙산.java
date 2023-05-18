import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int n;
    static int m;

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int level = 0;

        int[][] graph = new int[n][m];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = sc.nextInt();
                graph[i][j] = tmp;
                if (tmp > 0) {
                    q.offer(new Point(i, j));
                }
            }
        }


        while (!q.isEmpty()) {

            level++;
            int[][] copyGraph = copyGraph(graph);

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point tmp = q.poll();
                int zeroCount = findZero(tmp, graph);
                int melt = copyGraph[tmp.x][tmp.y] - zeroCount;
                if (melt <= 0) {
                    copyGraph[tmp.x][tmp.y] = 0;
                } else {
                    copyGraph[tmp.x][tmp.y] = melt;
                    q.offer(tmp);
                }
            }

            if (countSplit(copyGraph)) {
                answer =level;
                break;
            }

            graph = copyGraph;
        }
        System.out.println(answer);
    }

    static int findZero(Point tmp, int[][] graph) {

        int count = 0;

        for (int i = 0; i < 4; i++) {
            int mX = tmp.x + MOVE_X[i];
            int mY = tmp.y + MOVE_Y[i];

            if (mX >= 0 && mX < n && mY >= 0 && mY < m && graph[mX][mY] == 0) {
                count++;
            }
        }
        return count;
    }

    static boolean countSplit(int[][] graph) {
        int[][] copyGraph = copyGraph(graph);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyGraph[i][j] > 0) {
                    copyGraph[i][j] = 0;
                    count++;
                    if (count > 1) {
                        return true;
                    }
                    DFS(copyGraph, new Point(i, j));
                }
            }
        }
        return false;
    }

    static void DFS(int[][] graph, Point p) {
        for (int i = 0; i < 4; i++) {
            int mX = p.x + MOVE_X[i];
            int mY = p.y + MOVE_Y[i];

            if (mX >= 0 && mX < n && mY >= 0 && mY < m && graph[mX][mY] > 0) {
                graph[mX][mY] = 0;
                DFS(graph, new Point(mX, mY));
            }
        }
    }

    static int[][] copyGraph(int[][] graph) {

        int[][] copyGraph = new int[graph.length][graph[0].length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                copyGraph[i][j] = graph[i][j];
            }
        }
        return copyGraph;
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}