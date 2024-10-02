import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        array = new int[n];
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        System.out.println(recursion(0));
    }

    public static int recursion(int index) {

        if (dp[index] != -1) {
            return dp[index];
        }

        if (index == n) {
            return 0;
        }

        int max = 0;

        // 먹기 시작함
        int eat = 0;
        int start = index;
        for (; start < n; start++) {
            if (eat >= k) {
                break;
            }
            eat += array[start];
        }

        max = Math.max(max, recursion(start) + Math.max(eat - k, 0));

        // 안먹고 다음으로 넘김
        max = Math.max(max, recursion(index + 1));

        return dp[index] = max;
    }

}