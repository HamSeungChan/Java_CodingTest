import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] array;
    static boolean[][] check;
    static int[] MOVE_X = {1, 0, -1, 0};
    static int[] MOVE_Y = {0, 1, 0, -1};
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }


        int islandCount = 0;
        int islandNumber = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !check[i][j]) {
                    checkIsland(i, j, islandNumber);
                    islandCount++;
                    islandNumber++;
                }
            }
        }

        array = new int[islandNumber + 1];
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    makeBridge(i, j, map[i][j]);
                }
            }
        }

        int answer = 0;
        int bridgeCount = 0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();


            if (union(tmp.from, tmp.to)) {
                answer += tmp.value;
                bridgeCount++;
            }

            if (bridgeCount == islandCount - 1) {
                break;
            }
        }
        if (bridgeCount != islandCount - 1) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }


    }

    public static void checkIsland(int x, int y, int islandCount) {
        Queue<int[]> q = new LinkedList<>();
        check[x][y] = true;
        map[x][y] = islandCount;
        q.offer(new int[]{x, y});


        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < MOVE_X.length; i++) {
                int moveX = tmp[0] + MOVE_X[i];
                int moveY = tmp[1] + MOVE_Y[i];
                if (isValid(moveX, moveY) && map[moveX][moveY] == 1 && !check[moveX][moveY]) {
                    map[moveX][moveY] = islandCount;
                    check[moveX][moveY] = true;
                    q.offer(new int[]{moveX, moveY});
                }
            }
        }
    }

    public static void makeBridge(int x, int y, int islandNumber) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < MOVE_X.length; i++) {
            q.offer(new int[]{x, y, i});
        }

        int moveCount = 0;
        while (!q.isEmpty()) {

            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] tmp = q.poll();
                int moveX = tmp[0] + MOVE_X[tmp[2]];
                int moveY = tmp[1] + MOVE_Y[tmp[2]];

                if (isValid(moveX, moveY) && map[moveX][moveY] != islandNumber) {

                    int toMapNumber = map[moveX][moveY];
                    if (toMapNumber > 0) {
                        if (moveCount > 1) {
                            pq.offer(new Node(islandNumber, toMapNumber, moveCount));
                        }
                    } else {
                        q.offer(new int[]{moveX, moveY, tmp[2]});
                    }
                }
            }
            moveCount++;
        }

    }

    public static boolean union(int x, int y) {
        int findX = find(x);
        int findY = find(y);

        if (findX == findY) {
            return false;
        }

        array[findX] = findY;

        return true;
    }

    public static int find(int value) {
        if (value == array[value]) {
            return value;
        }
        return array[value] = find(array[value]);
    }

    public static boolean isValid(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Node implements Comparable<Node> {
    int from;
    int to;
    int value;

    public Node(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }


    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}