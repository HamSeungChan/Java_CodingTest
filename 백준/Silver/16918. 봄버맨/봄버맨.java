import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // map 전체를 스캔해야 하는가?
    static int[][] map;
    static int r, c;

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());
        int n = Integer.parseInt(token.nextToken());

        map = new int[r][c];

        // 폭탄은 3초 뒤에 터짐으로
        // 폭탄이 설치된 위치에 3을 넣는다

        for (int i = 0; i < r; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (tmp[j].equals("O")) {
                    // 처음 1초는 아무것도 안하기 때문에 폭탄이 터지는 시간을 2로 설정
                    map[i][j] = 2;
                }
            }
        }

        // 1초가 지난 후 부터 생각
        for (int time = 1; time < n; time++) {

            // 1초마다 timeFlow 호출
            List<Point> points = timeFlow();

            // 터지는 폭탄이 있을 때
            if (!points.isEmpty()) {
                for (Point p : points) {
                    for (int i = 0; i < MOVE_X.length; i++) {
                        int moveX = p.x + MOVE_X[i];
                        int moveY = p.y + MOVE_Y[i];

                        // 근처 칸 파괴
                        if (isRange(moveX, moveY)) {
                            map[moveX][moveY] = 0;
                        }
                    }
                }
            }


//            for (int i = 0; i < r; i++) {
//                for (int j = 0; j < c; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] >= 1) {
                    sb.append("O");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 시간이 흐름, 모든 배열에 -1값을 넣는다.

    public static List<Point> timeFlow() {

        List<Point> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j]--;

                // 폭탄 설치
                if (map[i][j] == -1) {
                    map[i][j] = 3;
                }

                // 폭탄이 터짐
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }
        return list;
    }

    // 폭탄이 터질 때 범위 확인
    public static boolean isRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
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