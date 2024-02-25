import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = array[0];
        int lastIndex = 1;

        for (int i = 1; i < n; i++) {
            if (dp[lastIndex - 1] < array[i]) {
                dp[lastIndex] = array[i];
                lastIndex++;
            } else {
                int index = lowerBound(dp, array[i], lastIndex);
                dp[index] = array[i];
            }
        }
        System.out.println(lastIndex);
    }

    public static int lowerBound(int[] dp, int value, int lastIndex) {
        int lt = 0;
        int rt = lastIndex;

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;
            if (dp[mid] >= value) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        return lt;
    }
}