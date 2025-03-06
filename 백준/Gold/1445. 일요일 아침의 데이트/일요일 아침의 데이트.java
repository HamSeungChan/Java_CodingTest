import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] MOVE_X = {1, 0, -1, 0};
    public static int[] MOVE_Y = {0, 1, 0, -1};

    static int[][] check;
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new int[n][m];
        check = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(check[i], Integer.MAX_VALUE);
        }

        int startX = 0, startY = 0;
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (tmp[j].equals("g")) {
                    map[i][j] = -1;
                } else if (tmp[j].equals("F")) {
                    map[i][j] = 2;
                } else if (tmp[j].equals("S")) {
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<Point> q = new PriorityQueue<>();
        q.add(new Point(startX, startY, 0, 0));

        while (!q.isEmpty()) {

            Point now = q.poll();
            if (check[now.x][now.y] <= now.garbage) {
                continue;
            }

            check[now.x][now.y] = now.garbage;


            for (int i = 0; i < 4; i++) {
                int moveX = now.x + MOVE_X[i];
                int moveY = now.y + MOVE_Y[i];

                if (inRange(moveX, moveY)) {

                    if (map[moveX][moveY] == 2) {
                        System.out.println(now.garbage + " " + now.garbageSize);
                        q.clear();
                        break;
                    }

                    if (map[moveX][moveY] == -1) {
                        q.offer(new Point(moveX, moveY, now.garbage + 1, now.garbageSize));
                        continue;
                    }

                    boolean flag = false;
                    for (int j = 0; j < 4; j++) {
                        int mX = moveX + MOVE_X[j];
                        int mY = moveY + MOVE_Y[j];

                        if (inRange(mX, mY) && map[mX][mY] == -1) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        q.offer(new Point(moveX, moveY, now.garbage, now.garbageSize + 1));
                        continue;
                    }

                    q.offer(new Point(moveX, moveY, now.garbage, now.garbageSize));
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

}


class Point implements Comparable<Point> {
    int x;
    int y;
    int garbage;
    int garbageSize;

    public Point(int x, int y, int garbage, int garbageSize) {
        this.x = x;
        this.y = y;
        this.garbage = garbage;
        this.garbageSize = garbageSize;
    }

    @Override
    public int compareTo(Point o) {
        if (this.garbage == o.garbage) {
            return this.garbageSize - o.garbageSize;
        }
        return this.garbage - o.garbage;
    }
}
