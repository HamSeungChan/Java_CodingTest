import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100_001;
    static boolean[] check = new boolean[MAX];
    static int[] before = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        bfs(n, k);

        int moveCount = 0;
        int endPoint = k;
        Stack<Integer> stack = new Stack<>();

//        reverse쓰면 두 자릿수에서 혼쭐남
//        StringBuilder sb = new StringBuilder();
//        while (true) {
//            if (endPoint == n) {
//                sb.append(endPoint);
//                break;
//            }
//            moveCount++;
//            sb.append(endPoint).append(" ");
//            endPoint = before[endPoint];
//        }
//        System.out.println(moveCount);
//        System.out.println(sb.reverse());

        while (true) {
            if (endPoint == n) {
                stack.push(endPoint);
                break;
            }
            moveCount++;
            stack.push(endPoint);
            endPoint = before[endPoint];
        }

        System.out.println(moveCount);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }


    }


    public static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = true;
        before[start] = start;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            if (tmp == end) {
                break;
            }
            // 뒤로 1 이동
            if (canMove(tmp - 1)) {
                q.offer(tmp - 1);
                check[tmp - 1] = true;
                before[tmp - 1] = tmp;
            }
            // 앞으로 1 이동
            if (canMove(tmp + 1)) {
                q.offer(tmp + 1);
                check[tmp + 1] = true;
                before[tmp + 1] = tmp;
            }
            // 순간 이동
            if (canMove(tmp * 2)) {
                q.offer(tmp * 2);
                check[tmp * 2] = true;
                before[tmp * 2] = tmp;
            }

        }

    }

    // 움직일 수 있는지 확인, 범위 & 방문 여부
    public static boolean canMove(int value) {
        return 0 <= value && value < MAX && !check[value];
    }
}