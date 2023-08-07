import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static int answer = 0;
    static int n;
    static int m;
    static boolean check[][];
    static String[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        array = new String[n][m];
        check = new boolean[n][m];
        Point startPoint = null;
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                array[i][j] = tmp[j];
                if (array[i][j].equals("I")) {
                    startPoint = new Point(i, j);
                    check[i][j] = true;
                }
            }
        }
        DFS(startPoint);
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    public static void DFS(Point p) {

        if (array[p.x][p.y].equals("P")) {
            answer++;
        }

        for (int i = 0; i < MOVE_Y.length; i++) {
            int moveX = p.x + MOVE_X[i];
            int moveY = p.y + MOVE_Y[i];

            if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < m && !check[moveX][moveY]
                    && !array[moveX][moveY].equals("X")) {
                check[moveX][moveY] = true;
                DFS(new Point(moveX, moveY));
            }
        }
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