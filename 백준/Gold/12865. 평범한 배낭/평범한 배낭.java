import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[][] array;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());

		array = new int[n][2];
		dp = new int[n][100001];

		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(token.nextToken());
			array[i][1] = Integer.parseInt(token.nextToken());
		}
		System.out.println(recursion(0, 0));
	}

	// public static void recursion(int index, int weight, int value)
	public static int recursion(int index, int weight) {

		if (weight > k) {
			return Integer.MIN_VALUE;
		}

		if (index == n) {
			return 0;
		}

		if (dp[index][weight] > 0) {
			return dp[index][weight];
		}

		return dp[index][weight] = Math.max(recursion(index + 1, weight + array[index][0]) + array[index][1],
			recursion(index + 1, weight));
	}

}