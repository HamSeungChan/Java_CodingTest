import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    private static final int NUMBER_OF_WALL = 3;
    private static final int[] MOVE_X = {-1, 0, 1, 0};
    private static final int[] MOVE_Y = {0, 1, 0, -1};

    static int n;
    static int m;

    static int[][] graph;
    static List<Point> zero = new ArrayList<>();
    static List<Point> virus = new ArrayList<>();
    int[] pick = new int[3];
    static int answer = Integer.MAX_VALUE;

    public void DFS(int level, int start) {
        if (level == NUMBER_OF_WALL) {
            int[][] newMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newMap[i][j] = graph[i][j];
                }
            }
            for (int x : pick) {
                Point p = zero.get(x);
                newMap[p.x][p.y] = 1;
            }
         
            Queue<Point> q = new LinkedList<>();
            int virusCount = 0;
            for (Point x : virus) {
                q.offer(x);
                virusCount++;
            }

            while (!q.isEmpty()) {
                Point x = q.poll();
                for (int i = 0; i < MOVE_X.length; i++) {
                    int mX = x.x + MOVE_X[i];
                    int mY = x.y + MOVE_Y[i];
                    if (0 <= mX && mX < n && 0 <= mY && mY < m && newMap[mX][mY] == 0) {
                        virusCount++;
                        newMap[mX][mY] = 2;
                        q.offer(new Point(mX, mY));
                    }
                }
            }
            answer = Math.min(virusCount, answer);
        } else {
            for (int i = start; i < zero.size(); i++) {
                pick[level] = i;
                DFS(level + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int oneCount = 0;
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 0) zero.add(new Point(i, j));
                if (graph[i][j] == 1) oneCount++;
                if (graph[i][j] == 2) virus.add(new Point(i, j));
            }
        }
        new Main().DFS(0, 0);
        System.out.println(n*m - NUMBER_OF_WALL - oneCount - answer);
    }
}
