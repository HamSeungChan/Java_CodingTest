import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] time = new int[100001];
    static int count;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        Arrays.fill(time, Integer.MAX_VALUE);
        bfs(n, k);
        System.out.println(answer);
        System.out.println(count);
    }

    public static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        time[start] = 0;
        int moveCount = 0;
        boolean flag = false;
        while (!q.isEmpty()) {
            if (flag) {
                break;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                if (tmp == end) {
                    answer = moveCount;
                    count++;
                    flag = true;
                }

                if (flag) {
                    continue;
                }

                int moveLeft = tmp - 1;
                int moveRight = tmp + 1;
                int moveJump = tmp * 2;

                if (checkRange(moveLeft)&&time[moveLeft] >= moveCount) {
                    time[moveLeft] = moveCount;
                    q.offer(moveLeft);
                }
                if (checkRange(moveRight) && time[moveRight] >= moveCount) {
                    time[moveRight] = moveCount;
                    q.offer(moveRight);
                }
                if (checkRange(moveJump) && time[moveJump] >= moveCount) {
                    time[moveJump] = moveCount;
                    q.offer(moveJump);
                }
            }
            moveCount++;
        }
    }

    public static boolean checkRange(int x) {
        return 0 <= x && x <= 100000;
    }
}