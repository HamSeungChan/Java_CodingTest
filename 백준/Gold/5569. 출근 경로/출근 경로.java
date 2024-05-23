import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int w, h;
	static int[] MOVE_X = {1, 0};
	static int[] MOVE_Y = {0, 1};
	static int[][][][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		w = Integer.parseInt(token.nextToken());
		h = Integer.parseInt(token.nextToken());

		dp = new int[w + 1][h + 1][2][3];
		for (int i = 0; i < w + 1; i++) {
			for (int j = 0; j < h + 1; j++) {
				for (int k = 0; k < 2; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		System.out.println(recursion(1, 1, 0, 2));

	}

	public static int recursion(int x, int y, int directionChange, int beforeMoveDirection) {

		if (x > w || y > h) {
			return 0;
		}

		if (x == w && y == h) {
			return 1;
		}

		if (beforeMoveDirection != -1 && dp[x][y][directionChange][beforeMoveDirection] != -1) {
			return dp[x][y][directionChange][beforeMoveDirection];
		}

		int sum = 0;
		// 전에 움직임을 변경하지 않음
		if (directionChange == 0) {
			// 처음 돌때
			if (beforeMoveDirection == 2) {
				for (int j = 0; j < 2; j++) {
					sum = sum % 100000 + recursion(x + MOVE_X[j], y + MOVE_Y[j], 0, j) % 100000;
				}
			} else {
				for (int j = 0; j < 2; j++) {
					sum = sum % 100000
						  + recursion(x + MOVE_X[j], y + MOVE_Y[j], (beforeMoveDirection == j ? 0 : 1), j) % 100000;
				}
			}
		}
		// 전에 움직임을 변경함.
		// 방향 그대로 가야 한다.
		else {
			sum = recursion(x + MOVE_X[beforeMoveDirection], y + MOVE_Y[beforeMoveDirection], 0, beforeMoveDirection)
				  % 100000;
		}
		return dp[x][y][directionChange][beforeMoveDirection] = sum % 100000;
	}
}