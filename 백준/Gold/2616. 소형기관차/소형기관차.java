import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] array;
	static int[][] dp;
	static int n, size;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = new int[n];

		dp = new int[n + 1][4];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}

		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}
		size = Integer.parseInt(br.readLine());

		System.out.println(recursion(0, 3));
	}

	public static int recursion(int index, int leftTrain) {

		if (index == n) {
			return 0;
		}

		if (dp[index][leftTrain] != -1) {
			return dp[index][leftTrain];
		}

		int answer = Integer.MIN_VALUE;

		if (leftTrain > 0) {
			// 선택한 경우
			int tmp = 0;
			int nextIndex = index + size;
			if (index + size >= n) {
				nextIndex = n;
			}
			for (int i = index; i < nextIndex; i++) {
				tmp += array[i];
			}
			answer = Math.max(answer, recursion(nextIndex, leftTrain - 1) + tmp);
		}
		// 선택을 하지 않는 경우
		answer = Math.max(answer, recursion(index + 1, leftTrain));

		return dp[index][leftTrain] = answer;
	}

}