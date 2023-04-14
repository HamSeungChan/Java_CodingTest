import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static final int[] MOVE_X = {0, 1, 0, -1};
    public static final int[] MOVE_Y = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        int answer = 0;
        List<Integer> houseCount = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    answer++;
                    houseCount.add(m.BFS(graph, new Point(i, j), n));
                }
            }
        }
        System.out.print(answer);
        Collections.sort(houseCount);
        for (int x : houseCount) {
            System.out.println();
            if (x != 0) {
                System.out.print(x);
            }
        }
    }

    public int BFS(int[][] graph, Point p, int n) {
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        int houseCount = 1;
        graph[p.x][p.y] = 0;
        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < 4; i++) {
                int mX = tmp.x + MOVE_X[i];
                int mY = tmp.y + MOVE_Y[i];

                if (0 <= mX && mX < n && 0 <= mY && mY < n && graph[mX][mY] == 1) {
                    q.offer(new Point(mX, mY));
                    graph[mX][mY] = 0;
                    houseCount++;
                }
            }
        }
        return houseCount;
    }
}
