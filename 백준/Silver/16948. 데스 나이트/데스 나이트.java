import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] MOVE_X = {-2, -2, 0, 0, 2, 2};
    static int[] MOVE_Y = {-1, 1, -2, 2, -1, 1};
    static int n, r1, c1, r2, c2;
    static int[][] array = new int[n][n];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(token.nextToken());
        c1 = Integer.parseInt(token.nextToken());
        r2 = Integer.parseInt(token.nextToken());
        c2 = Integer.parseInt(token.nextToken());

        array = new int[n][n];

        System.out.println(bfs());
    }

    public static int bfs() {
        int answer = -1;
        Queue<Point> q = new LinkedList<>();
        boolean[][] check = new boolean[n][n];
        check[r1][c1] = true;
        q.offer(new Point(r1, c1));
        int moveCount = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point tmp = q.poll();
                if(tmp.x == r2 && tmp.y == c2){
                    return moveCount;
                }
                for (int j = 0; j < MOVE_X.length; j++) {
                    int moveX = tmp.x + MOVE_X[j];
                    int moveY = tmp.y + MOVE_Y[j];
                    if (isRange(moveX, moveY) && !check[moveX][moveY]) {
                        check[moveX][moveY] = true;
                        q.offer(new Point(moveX, moveY));
                    }
                }
            }
            moveCount++;
        }

        return answer;
    }

    static public boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
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