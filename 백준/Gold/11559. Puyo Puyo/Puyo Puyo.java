import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static int[] MOVE_X = {1, 0, -1, 0};
    public static int[] MOVE_Y = {0, 1, 0, -1};
    public static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int count = 0;
        while (true) {

//            for (int i = 0; i < 12; i++) {
//                for (int j = 0; j < 6; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            boolean flag = false;
            boolean[][] checkVisited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !checkVisited[i][j]) {

                        List<Point> group = checkGroup(new Point(i, j), map[i][j], checkVisited);
                        if (group.size() < 4) {
                            continue;
                        }

                        flag = true;
                        breakGroup(group);
                    }
                }
            }

            if (!flag) {
                break;
            }

            move();
            count++;
        }

        System.out.println(count);
    }


    // 모든 map 에서 같은 색의 뿌요들이 4개 이상인 그룹을 찾는다.
    public static List<Point> checkGroup(Point p, char c, boolean[][] checkVisited) {

        List<Point> group = new ArrayList<>();
        Queue<Point> q = new ArrayDeque<>();

        group.add(p);
        checkVisited[p.x][p.y] = true;
        q.add(p);

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = now.x + MOVE_X[i];
                int moveY = now.y + MOVE_Y[i];

                if (inRange(moveX, moveY) && !checkVisited[moveX][moveY] && map[moveX][moveY] == c) {

                    checkVisited[moveX][moveY] = true;
                    Point newPoint = new Point(moveX, moveY);
                    q.add(newPoint);
                    group.add(newPoint);
                }
            }
        }
        return group;
    }

    // 뿌요 그룹을 터트린다.
    public static void breakGroup(List<Point> group) {

        for (Point point : group) {
            map[point.x][point.y] = '.';
        }

    }

    // 뿌요들이 내려오게 한다.
    public static void move() {

        for (int j = 0; j < 6; j++) {

            for (int i = 11; i >= 0; i--) {
                if (map[i][j] == '.') {
                    int lastIndex = i - 1;
                    while (lastIndex >= 0) {
                        if (map[lastIndex][j] != '.') {
                            char tmp = map[lastIndex][j];
                            map[i][j] = tmp;
                            map[lastIndex][j] = '.';
                            break;
                        }
                        lastIndex--;
                    }
                }
            }
        }
    }

    // 범위
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < 12 && 0 <= y && y < 6;
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