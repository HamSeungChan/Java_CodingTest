import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, answer = Integer.MAX_VALUE;
	static int[][] array;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = new int[n][4];
		dp = new int[n + 1][4];

		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		System.out.println(recursion(0, 0));
	}

	public static int recursion(int index, int before) {

		if (index == n) {
			return 0;
		}

		if (dp[index][before] != -1) {
			return dp[index][before];
		}

		int tmp = Integer.MAX_VALUE;

		for (int i = 1; i <= 3; i++) {
			if (before != i) {
				tmp = Math.min(tmp, recursion(index + 1, i) + array[index][i]);
			}
		}
		dp[index][before] = tmp;
		return tmp;
	}
}