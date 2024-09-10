import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, answer = 0;
    static int[] time, bound, value;
    static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];
        time = new int[n + 1];
        bound = new int[n + 1];
        value = new int[n + 1];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            time[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            bound[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int lastIndex = findLowerBound(i - 1, time[i] - bound[i] - 1);
            if (lastIndex < 0) {
                dp[i] = Math.max(dp[i - 1] , value[i]);
            }else{
                dp[i] = Math.max(dp[lastIndex] + value[i], dp[i - 1]);
            }
        }

        System.out.println(dp[n]);
//        System.out.println(recursion(0, 0));
    }

    public static int findLowerBound(int rt, int findTime) {

        int lt = 0;
        int index = -1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (time[mid] <= findTime) {
                index = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return index;
    }


    public static int recursion(int index, int lastTime) {

        if (index == n) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE;

        // 어를 외친다.
        int boundTime = time[index] - bound[index];
        if (lastTime < boundTime) {
            maxValue = Math.max(maxValue, recursion(index + 1, time[index]) + value[index]);
        }

        // 어를 외치지 않는다.
        return Math.max(maxValue, recursion(index + 1, lastTime));
    }

}