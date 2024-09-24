import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long n, x;
    static int m;
    static int[] money;
    static long[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Long.parseLong(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        x = Long.parseLong(token.nextToken());

        money = new int[m];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            money[i] = Integer.parseInt(token.nextToken());
        }

        answer = new long[m];
        for (int i = 0; i < m; i++) {
            find(i);
            n -= answer[i];
            x -= answer[i] * money[i];
        }

        StringBuilder sb = new StringBuilder();
        for (long l : answer) {
            sb.append(l).append(" ");
        }
        System.out.print(sb);
    }

    public static void find(int index) {

        long lt = 0;
        long rt = n;

        while (lt <= rt) {

            long mid = (lt + rt) / 2;
            long nowMoney = money[index] * mid;

            // 남은 인원을 최소 금액으로 맞췄을 때
            long leftMoney = (n - mid) * money[m - 1];

            if (leftMoney <= x - nowMoney) {
                answer[index] = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
    }
}