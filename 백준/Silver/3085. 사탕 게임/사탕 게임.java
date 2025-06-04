import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, max = 1;
    static char[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = s.charAt(j);
            }
        }

        searchRow();
        searchCol();
        System.out.println(max);

    }

    public static void searchRow() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                rowCheck();
                colCheck();
                swap(i, j + 1, i, j);
            }
        }
    }

    public static void searchCol() {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                swap(i, j, i + 1, j);
                rowCheck();
                colCheck();
                swap(i + 1, j, i, j);
            }
        }
    }

    public static void rowCheck() {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = array[x1][y1];
        array[x1][y1] = array[x2][y2];
        array[x2][y2] = tmp;
    }

    public static void colCheck() {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (array[j][i] == array[j + 1][i]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }
}