import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] array;
	static int[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		array = new int[n][2];
		dp = new int[n];

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		System.out.println(recursion(0));
	}

	public static int recursion(int day) {

		if (day == n) {
			return 0;
		}

		if (day + array[day][0] > n) {
			return dp[day] = recursion(day + 1);
		}

		if (dp[day] > 0) {
			return dp[day];
		}

		return dp[day] = max(recursion(day + array[day][0]) + array[day][1], recursion(day + 1));
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}
}