import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int[][] array;
    static boolean[][] check;
    static int n, l, r;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        l = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());

        array = new int[n][n];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int day = 0;
        while (true) {
            int booleanCount = 0;
            check = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!check[i][j]) {
                        if (!bfs(new Point(i, j))) {
                            booleanCount++;
                        }
                    }
                }
            }

            if (booleanCount == n * n) {
                break;
            }
            day++;
        }
        System.out.println(day);
    }

    public static boolean bfs(Point p) {

        Queue<Point> q = new LinkedList<>();
        Stack<Point> stack = new Stack<>();

        int totalPeople = array[p.x][p.y];
        check[p.x][p.y] = true;

        q.offer(p);
        stack.push(p);

        while (!q.isEmpty()) {

            Point tmp = q.poll();


            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = tmp.x + MOVE_X[i];
                int moveY = tmp.y + MOVE_Y[i];
                if (isRange(moveX, moveY) && canMove(tmp.x, tmp.y, moveX, moveY) && !check[moveX][moveY]) {
                    Point newPoint = new Point(moveX, moveY);
                    check[moveX][moveY] = true;
                    totalPeople += array[moveX][moveY];

                    q.offer(newPoint);
                    stack.push(newPoint);
                }
            }
        }

        if (stack.size() == 1) {
            return false;
        }

        int average = totalPeople / stack.size();
        while (!stack.isEmpty()) {

            Point tmp = stack.pop();
            array[tmp.x][tmp.y] = average;
        }
        return true;
    }


    public static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }


    public static boolean canMove(int nowX, int nowY, int moveX, int moveY) {
        int diff = Math.abs(array[nowX][nowY] - array[moveX][moveY]);
        return l <= diff && diff <= r;
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