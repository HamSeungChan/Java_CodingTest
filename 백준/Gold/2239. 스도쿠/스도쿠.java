import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Point> list = new ArrayList<>();
    static int[][] array = new int[9][9];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                array[i][j] = Integer.parseInt(s[j]);
                if (array[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        DFS(0);
    }

    public static void DFS(int index) {

        if(flag){
            return;
        }

        if (index == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(array[i][j]);
                }
                System.out.println();
            }
            flag = true;
        } else {
            Point tmp = list.get(index);
            for (int i = 1; i <= 9; i++) {
                if (check(tmp.x, tmp.y, i)) {
                    array[tmp.x][tmp.y] = i;
                    DFS(index + 1);
                    array[tmp.x][tmp.y] = 0;
                }

            }
        }
    }

    public static boolean check(int x, int y, int value) {

        for (int i = 0; i < 9; i++) {

            if (array[x][i] == value) {
                return false;
            }
            if (array[i][y] == value) {
                return false;
            }
        }

        int xx = (x / 3) * 3;
        int yy = (y / 3) * 3;

        for (int i = xx; i < xx + 3; i++) {
            for (int j = yy; j < yy + 3; j++) {

                if (array[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
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