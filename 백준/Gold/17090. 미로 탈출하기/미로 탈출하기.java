import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<Point> set = new HashSet<>();
    static int n, m, answer = 0;
    static char[][] array;
    static boolean[][] check;
    static boolean[][] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        array = new char[n][m];
        check = new boolean[n][m];
        depth = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                array[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    dfs(new Point(i, j),1);
                }
            }
        }

        System.out.println(answer);
    }

    static boolean dfs(Point p , int count) {

        check[p.x][p.y] = true;

        int mX = p.x;
        int mY = p.y;
        char c = array[p.x][p.y];
        if (c == 'U') {
            mX -= 1;
        } else if (c == 'D') {
            mX += 1;
        } else if (c == 'L') {
            mY -= 1;
        } else {
            mY += 1;
        }

        if (isOutRange(mX, mY) || depth[mX][mY]) {
            depth[p.x][p.y] = true;
            answer+=count;
            return true;
        }

        if (check[mX][mY]) {
            return false;
        }

        return depth[p.x][p.y] = dfs(new Point(mX, mY) , count +1);

    }

    static boolean isOutRange(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
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