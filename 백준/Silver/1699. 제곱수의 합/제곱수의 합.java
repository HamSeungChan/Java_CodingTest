import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);

		System.out.println(recursion(n));
	}

	public static int recursion(int n) {

		if (dp[n] != -1) {
			return dp[n];
		}

		if (n == 0) {
			return 0;
		}
		int tmp = Integer.MAX_VALUE;

		for (int i = 1; i <= Math.sqrt(n); i++) {
			tmp = Math.min(tmp, recursion(n - i * i) + 1);
		}

		return dp[n] = tmp;
	}
}