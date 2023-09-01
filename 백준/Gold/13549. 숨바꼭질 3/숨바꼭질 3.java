import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check = new boolean[100001];
    ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int answer = move(n, k);
        System.out.println(answer);

    }


    public static int move(int start, int end) {

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(start, 0));


        int moveCount = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Info tmp = q.poll();
                if (tmp.value == end) {
                    return moveCount - tmp.jumpCount;
                }

                int jumpValue = tmp.value * 2;
                int front = tmp.value + 1;
                int back = tmp.value - 1;

                if (canMove(jumpValue)) {
                    q.offer(new Info(tmp.value * 2, tmp.jumpCount + 1));
                    check[jumpValue] = true;
                }

                if (canMove(back)) {
                    q.offer(new Info(tmp.value - 1, tmp.jumpCount));
                    check[back] = true;
                }

                if (canMove(front)) {
                    q.offer(new Info(tmp.value + 1, tmp.jumpCount));
                    check[front] = true;
                }

            }
            moveCount++;
        }

        return -1;
    }

    public static boolean canMove(int value) {
        return 0 <= value && value < check.length && !check[value];
    }
}

class Info {
    int value;
    int jumpCount;

    public Info(int value, int jumpCount) {
        this.value = value;
        this.jumpCount = jumpCount;
    }
}