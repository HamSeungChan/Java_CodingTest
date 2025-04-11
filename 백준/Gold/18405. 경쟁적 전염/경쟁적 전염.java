import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[][] map = new int[n][n];
        Queue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(token.nextToken());
                map[i][j] = value;
                if (value != 0) {
                    pq.add(new Info(i, j, 0, value));
                }
            }
        }

        token = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(token.nextToken());
        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());

        for (int i = 0; i < s; i++) {

            int qSize = pq.size();
            for (int j = 0; j < qSize; j++) {

                Info now = pq.poll();
                for (int l = 0; l < MOVE_X.length; l++) {

                    int moveX = now.x + MOVE_X[l];
                    int moveY = now.y + MOVE_Y[l];
                    if (0 <= moveX && moveX < n && 0 <= moveY && moveY < n && map[moveX][moveY] == 0) {
                        map[moveX][moveY] = now.value;
                        pq.add(new Info(moveX, moveY, now.depth + 1, now.value));
                    }
                }
            }
        }

        System.out.println(map[x - 1][y - 1]);

    }
}

class Info implements Comparable<Info> {

    int x;
    int y;
    int depth;
    int value;

    public Info(int x, int y, int depth, int value) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.value = value;
    }

    @Override
    public int compareTo(Info o) {

        if (this.depth == o.depth) {
            return this.value - o.value;
        }
        return this.depth - o.depth;
    }
}
