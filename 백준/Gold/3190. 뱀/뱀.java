import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int APPLE = 100;
    static final int SNAKE_LOCATION = 200;
    static int[] MOVE_X = {0, 1, 0, -1};
    static int[] MOVE_Y = {1, 0, -1, 0};
    static Map<Integer, String> directionChangeMap = new HashMap<>();
    static int[][] map;
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // map 사이즈
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // 사과의 위치
        int appleCount = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for (int i = 0; i < appleCount; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(token.nextToken()) - 1;
            int y = Integer.parseInt(token.nextToken()) - 1;
            map[x][y] = APPLE;
        }

        // 방향 변환 정보
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(token.nextToken());
            String c = token.nextToken();
            directionChangeMap.put(x, c);
        }
        System.out.println(game());
    }

    public static int game() {
        int time = 0;
        int direction = 0;
        Point head = new Point(0, 0);
        map[0][0] = SNAKE_LOCATION;
        Queue<Point> snake = new LinkedList<>();

        snake.add(head);

        while (true) {

            time++;
            int moveX = head.x + MOVE_X[direction];
            int moveY = head.y + MOVE_Y[direction];

//            System.out.println("time : " + time + " = " + moveX + " " + moveY);

            if (!isCanMove(moveX, moveY)) {
                break;
            }
            
            // 사과를 먹지 않았을 때
            if (map[moveX][moveY] != APPLE) {
                Point tmp = snake.poll();
                map[tmp.x][tmp.y] = 0;
            }

            // 새로운 움직임
            Point newHead = new Point(moveX, moveY);
            snake.add(newHead);
            head = newHead;
            map[newHead.x][newHead.y] = SNAKE_LOCATION;


            // 방향 바뀌는지 확인
            if (directionChangeMap.containsKey(time)) {
                direction = changeDirection(direction, time);
            }
        }

        return time;
    }

    private static int changeDirection(int direction, int time) {
        if (directionChangeMap.get(time).equals("D")) {
            direction = (direction + 1) % 4;
        } else {
            direction = (direction - 1 + 4) % 4;
        }
        return direction;
    }

    public static boolean isCanMove(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && map[x][y] != SNAKE_LOCATION;
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