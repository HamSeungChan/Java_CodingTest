import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n;
	static long[][][][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new long[n + 1][3][3][2];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		System.out.println(recursion(2, 0, 0, 0));
	}

	/*
	 * index - 위치
	 * beforeMap - 이전 map 존재
	 * flag - 2층 map 사용했는지
	 * */
	public static long recursion(int index, int beforebeforeMap, int beforeMap, int flag) {

		if (index == n + 1) {
			if (flag == 1) {
				return 1;
			}
			return 0;
		}

		if (dp[index][beforebeforeMap][beforeMap][flag] != -1) {
			return dp[index][beforebeforeMap][beforeMap][flag];
		}

		long count = 0;
		// 연속해서 3 번 나오는 경우
		if (beforeMap > 0 && beforebeforeMap > 0) {
			count = recursion(index + 1, beforeMap, 0, flag) % 1000000007;
		} else {
			for (int i = 0; i < 3; i++) {
				if (i == 2) {
					// 크기가 2인 선인장이 연속 2번 나오는지 확인
					if (beforeMap != 2) {
						count = count % 1000000007 + recursion(index + 1, beforeMap, i, 1) % 1000000007;
					}
				} else {
					count = count % 1000000007 + recursion(index + 1, beforeMap, i, flag) % 1000000007;
				}
			}
		}
		return dp[index][beforebeforeMap][beforeMap][flag] = count;
	}
}