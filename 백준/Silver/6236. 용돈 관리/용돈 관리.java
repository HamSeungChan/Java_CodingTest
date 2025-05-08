import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] money;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int lt = 1;
        int rt = n * 10000;
        int answer = 0;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            if (find(mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static int find(int value) {

        int nowMoney = 0;
        int withdrawCount = 0;

        for (int i = 0; i < money.length; i++) {

            if (money[i] > value) {
                return 10000001;
            }

            if (money[i] > nowMoney) {
                withdrawCount++;
                nowMoney = value;
            }

            nowMoney -= money[i];
        }
        return withdrawCount;
    }
}