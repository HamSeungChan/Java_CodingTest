import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] array;
    static int n, m;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, -1, 0, 1};
    static int village;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());


        array = new int[n][m];
        List<Point> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(split[j]);
                if (array[i][j] == 1) {
                    village++;
                    continue;
                }
                tmp.add(new Point(i, j));
            }
        }


        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = i + 1; j < tmp.size(); j++) {
                answer = Math.min(answer, bfs(tmp.get(i), tmp.get(j)));
            }
        }
        System.out.println(answer);
    }

    public static int bfs(Point point1, Point point2) {


        Queue<Point> q = new ArrayDeque<>();
        boolean[][] check = new boolean[n][m];

        check[point1.x][point1.y] = true;
        check[point2.x][point2.y] = true;

        q.offer(point1);
        q.offer(point2);

        int time = 0;
        int infectionCount = 0;

        while (!q.isEmpty()) {

            if (infectionCount == village) {
                break;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {

                Point poll = q.poll();

                for (int j = 0; j < MOVE_X.length; j++) {
                    int moveX = poll.x + MOVE_X[j];
                    int moveY = poll.y + MOVE_Y[j];

                    if (check(moveX, moveY, check)) {
                        q.offer(new Point(moveX, moveY));
                        check[moveX][moveY] = true;
                        if (array[moveX][moveY] == 1) {
                            infectionCount++;
                        }
                    }
                }
            }
            time++;
        }

        return time;
    }

    public static boolean check(int x, int y, boolean[][] check) {
        return 0 <= x && x < n && 0 <= y && y < m && !check[x][y];
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}