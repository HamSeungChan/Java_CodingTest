import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int n, m;
    static int imageCount = 0;
    static int bigImage = 0;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 1) {
                    imageCount++;
                    bigImage = Math.max(bigImage, findImage(new Point(i, j)));
                }
            }
        }

        System.out.println(imageCount);
        System.out.println(bigImage);
    }

    public static int findImage(Point p) {

        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        array[p.x][p.y] = 0;
        int count = 0;

        while (!q.isEmpty()) {
            Point poll = q.poll();
            count++;

            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = poll.x + MOVE_X[i];
                int moveY = poll.y + MOVE_Y[i];
                if (isRange(moveX, moveY) && array[moveX][moveY] == 1) {
                    array[moveX][moveY] = 0;
                    q.offer(new Point(moveX, moveY));
                }

            }
        }
        return count;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
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