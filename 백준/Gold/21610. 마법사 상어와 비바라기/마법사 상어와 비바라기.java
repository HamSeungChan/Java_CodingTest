import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] X = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] Y = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int n;

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Point> groom = new LinkedList<>();
        n = sc.nextInt();
        int m = sc.nextInt();
        int[][] check = new int[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        groom.offer(new Point(n - 1, 0));
        groom.offer(new Point(n - 1, 1));
        groom.offer(new Point(n - 2, 0));
        groom.offer(new Point(n - 2, 1));


        for (int move = 0; move < m; move++) {
            int direction = sc.nextInt();
            int distance = sc.nextInt();


            for (Point p : groom) {
                for (int d = 0; d < distance; d++) {
                    p.x = (n + p.x + X[direction - 1]) % n;
                    p.y = (n + p.y + Y[direction - 1]) % n;
                }
                map[p.x][p.y]++;
            }

            while (!groom.isEmpty()) {
                Point tmp = groom.poll();
                check[tmp.x][tmp.y] = 1;

                for (int t = 1; t < X.length; t = t + 2) {
                    int moveX = tmp.x + X[t];
                    int moveY = tmp.y + Y[t];
                    if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < n && map[moveX][moveY] > 0) {
                        map[tmp.x][tmp.y]++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j] == 0 && map[i][j] >= 2) {
                        map[i][j] -= 2;
                        groom.add(new Point(i, j));
                    }
                }
            }

            check = new int[n][n];

        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);

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

