import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] man, woman, minArray, maxArray;
    static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        man = new int[n];
        woman = new int[m];

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            man[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            woman[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(man);
        Arrays.sort(woman);

        if (n > m) {
            solution(man, woman);
        } else {
            solution(woman, man);
        }

    }

    // a 인원 수가 더 많은
    // b 인원 수가 더 적은
    public static void solution(int[] a, int[] b) {

        maxArray = a;
        minArray = b;

        dp = new long[maxArray.length + 1][minArray.length + 1];
        for (int i = 0; i < maxArray.length + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursion(0, 0));
    }

    public static long recursion(int index, int mIndex) {

        if (dp[index][mIndex] != -1) {
            return dp[index][mIndex];
        }

        if (mIndex == minArray.length) {
            return 0;
        }

        if (index == maxArray.length) {
            return 1000000000000L;
        }

        return dp[index][mIndex] = Math.min(recursion(index + 1, mIndex + 1) + Math.abs(maxArray[index] - minArray[mIndex])
                , recursion(index + 1, mIndex));
    }
}