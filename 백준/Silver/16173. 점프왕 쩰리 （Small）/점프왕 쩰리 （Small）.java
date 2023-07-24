import java.util.Scanner;

public class Main {

    static String answer = "Hing";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        DFS(map, n, new Point(0, 0), new int[n][n]);
        System.out.println(answer);
    }

    static void DFS(int[][] map, int n, Point p, int[][] array) {

        array[p.x][p.y] = 1;

        if (map[p.x][p.y] == -1) {
            answer = "HaruHaru";
        } else {
            int mX = p.x + map[p.x][p.y];
            int mY = p.y + map[p.x][p.y];
            if (mX >= 0 && mX < n && array[mX][p.y] == 0) {
                DFS(map, n, new Point(mX, p.y), array);
            }
            if (mY >= 0 && mY < n && array[p.x][mY] == 0) {
                DFS(map, n, new Point(p.x, mY), array);
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}