import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static final int INF = 1_000 * 1_000;
	static int array[][];
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		array = new int[n + 1][3];

		StringTokenizer token;
		for (int i = 1; i <= n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		int answer = INF;

		for (int i = 0; i < 3; i++) {
			int[][] dp = new int[n + 1][3];
			Arrays.fill(dp[1], INF);
			dp[1][i] = array[1][i];
			answer = Math.min(answer, find(dp, i));
		}

		System.out.println(answer);

	}

	public static int find(int[][] dp, int start) {

		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + array[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + array[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + array[i][2];
		}

		int minValue = INF;
		for (int i = 0; i < 3; i++) {

			if (start != i) {
				minValue = Math.min(minValue, dp[n][i]);
			}
		}
		return minValue;
	}
}