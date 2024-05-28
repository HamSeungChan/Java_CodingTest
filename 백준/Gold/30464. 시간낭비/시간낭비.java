import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] array;
	static int[][][] dp;
	static boolean flag;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = new int[n + 1];
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}

		dp = new int[n + 1][3][2];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < 3; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		recursion(1, 0, 1);
		System.out.println(flag ? dp[1][0][1] : -1);
	}

	public static int recursion(int index, int turnCount, int direction) {

		if (index == n) {
			flag = true;
			return 0;
		}

		if (array[index] == 0) {
			return -1000000;
		}

		if (dp[index][turnCount][direction] != -1) {
			return dp[index][turnCount][direction];
		}

		int tmp = Integer.MIN_VALUE;
		int d = 1;

		if (direction == 0) {
			d = d * -1;
		}

		// 그냥 갈거야
		if (index + array[index] * d > 0 && index + array[index] * d <= n) {
			tmp = Math.max(tmp, recursion(index + array[index] * d, turnCount, direction) + 1);
		}

		// 돌거야
		d *= -1;
		if (index + array[index] * d > 0 && index + array[index] * d <= n && turnCount < 2) {
			tmp = Math.max(tmp, recursion(index + array[index] * d, turnCount + 1, (direction == 1 ? 0 : 1)) + 1);
		}

		return dp[index][turnCount][direction] = tmp;
	}
}