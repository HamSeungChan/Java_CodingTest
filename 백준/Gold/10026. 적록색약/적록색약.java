import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int[] MOVE_X = {1, 0, -1, 0};
    static final int[] MOVE_Y = {0, 1, 0, -1};

    static String[][] array;
    static boolean[][] check;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new String[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                array[i][j] = s[j];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    dfs(new Point(i, j));
                    answer++;
                }
            }
        }

        System.out.print(answer + " ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j].equals("G")) {
                    array[i][j] = "R";
                }
            }
        }

        answer = 0;
        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    dfs(new Point(i, j));
                    answer++;
                }
            }
        }

        System.out.print(answer + " ");


    }

    public static void dfs(Point p) {

        String tmp = array[p.x][p.y];

        for (int i = 0; i < MOVE_X.length; i++) {
            int moveX = p.x + MOVE_X[i];
            int moveY = p.y + MOVE_Y[i];
            if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < n && array[moveX][moveY].equals(tmp)
                    && !check[moveX][moveY]) {
                check[moveX][moveY] = true;
                dfs(new Point(moveX, moveY));
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