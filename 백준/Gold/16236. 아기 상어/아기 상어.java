import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] MOVE_X = {-1, 0, 1, 0};
    public static int[] MOVE_Y = {0, 1, 0, -1};
    static int[][] graph;
    static Point sharkLocation;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        int answer = 0;
        graph = new int[size][size];

        StringTokenizer token;
        for (int i = 0; i < size; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(token.nextToken());
                if (graph[i][j] == 9) {
                    graph[i][j] = 0;
                    sharkLocation = new Point(i, j,0);
                }
            }
        }

        while (true) {


            int time = findFish(sharkLocation);

//            if (fishCount == 1) {
//                for (int i = 0; i < size; i++) {
//                    for (int j = 0; j < size; j++) {
//                        if (graph[i][j] > 0 && graph[i][j] < 9) {
//                            answer += Math.abs(sharkLocation.x - i) + Math.abs(sharkLocation.y - j);
//                        }
//                    }
//                }
//                break;
//            }

            if (time == -1) {
                break;
            }
            answer += time;
        }
        System.out.println(answer);
    }

    public static int findFish(Point p) {

        int time = 0;
        boolean check[][] = new boolean[size][size];
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(p);
        check[p.x][p.y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point tmp = q.poll();
                if (graph[tmp.x][tmp.y] < sharkSize && graph[tmp.x][tmp.y] > 0) {
                    eatCount++;
                    graph[tmp.x][tmp.y] = 0;
                    sharkLocation = new Point(tmp.x, tmp.y, tmp.distance);

                    if (eatCount == sharkSize) {
                        sharkSize++;
                        eatCount = 0;
                    }
                    return time;
                }

                for (int j = 0; j < MOVE_X.length; j++) {
                    int moveX = tmp.x + MOVE_X[j];
                    int moveY = tmp.y + MOVE_Y[j];
                    if (isValid(moveX, moveY) && !check[moveX][moveY]) {
                        check[moveX][moveY] = true;
                        q.offer(new Point(moveX, moveY, time));
                    }
                }
            }
            time++;
        }

        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && graph[x][y] <= sharkSize;
    }
}


class Point implements Comparable<Point> {
    int x;
    int y;
    int distance;

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }


    @Override
    public int compareTo(Point o) {

        if (this.distance == o.distance) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
        return this.distance - o.distance;

    }
}