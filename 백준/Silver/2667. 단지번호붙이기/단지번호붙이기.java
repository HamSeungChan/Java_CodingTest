import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[][] array;
    static boolean[][] check;
    static int n;
    static int[] move_x = {1, 0, -1, 0};
    static int[] move_y = {0, 1, 0, -1};
    static int count = 0;
    static int size = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j] && array[i][j] != 0) {
                    count++;
                    size = 0;
                    dfs(new Point(i, j));
                    answer.add(size);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        Collections.sort(answer);
        for (Integer i : answer) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(Point p) {

        check[p.x][p.y] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int moveX = p.x + move_x[i];
            int moveY = p.y + move_y[i];
            if (canMove(moveX, moveY)) {
                dfs(new Point(moveX, moveY));
            }
        }
    }

    public static boolean canMove(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n && array[x][y] != 0 && !check[x][y];
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