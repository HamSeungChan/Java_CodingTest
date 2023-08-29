import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[m + 1];
		Arrays.fill(dp, 100_000_000);
		dp[0] = 0;

		for (int i : array) {
			for (int j = i; j <= m; j++) {
				dp[j] = Math.min(dp[j - i] + 1, dp[j]);
			}
			
		}
		
		if (dp[m] == 100_000_000) {
			System.out.println(-1);
		} else {
			System.out.print(dp[m]);
		}

		
	}
}