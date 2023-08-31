import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] DIRECTION_ZERO = { { 0, 1, 0 }, { 1, 1, 1 } };
	static int[][] DIRECTION_ONE = { { 0, 1, 0 }, { 1, 0, 2 }, { 1, 1, 1 } };
	static int[][] DIRECTION_TWO = { { 1, 0, 2 }, { 1, 1, 1 } };

	static int[] CHECK_X = { -1, 0 };
	static int[] CHECK_Y = { 0, -1 };

	static int n, array[][];
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		array = new int[n][n];
		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		DFS(new Point(0, 1, 0));
		System.out.println(answer);

	}

	public static void DFS(Point p) {

		if (p.x == n - 1 && p.y == n - 1) {
			answer++;
		} else {

			int moveX = 0;
			int moveY = 0;
			int moveDirection = 0;

			if (p.direction == 0) {

				for (int i = 0; i < DIRECTION_ZERO.length; i++) {
					moveX = p.x + DIRECTION_ZERO[i][0];
					moveY = p.y + DIRECTION_ZERO[i][1];
					moveDirection = DIRECTION_ZERO[i][2];

					if (isRange(moveX, moveY) && array[moveX][moveY] == 0) {
						if (moveDirection == 1) {
							if (!checkMoveDirectionOnde(moveX, moveY)) {
								continue;
							}
						}
						DFS(new Point(moveX, moveY, moveDirection));
					}
				}

			} else if (p.direction == 1) {
				for (int i = 0; i < DIRECTION_ONE.length; i++) {
					moveX = p.x + DIRECTION_ONE[i][0];
					moveY = p.y + DIRECTION_ONE[i][1];
					moveDirection = DIRECTION_ONE[i][2];

					if (isRange(moveX, moveY) && array[moveX][moveY] == 0) {
						if (moveDirection == 1) {
							if (!checkMoveDirectionOnde(moveX, moveY)) {
								continue;
							}
						}
						DFS(new Point(moveX, moveY, moveDirection));
					}
				}
			} else {
				for (int i = 0; i < DIRECTION_TWO.length; i++) {
					moveX = p.x + DIRECTION_TWO[i][0];
					moveY = p.y + DIRECTION_TWO[i][1];
					moveDirection = DIRECTION_TWO[i][2];

					if (isRange(moveX, moveY) && array[moveX][moveY] == 0) {
						if (moveDirection == 1) {
							if (!checkMoveDirectionOnde(moveX, moveY)) {
								continue;
							}
						}
						DFS(new Point(moveX, moveY, moveDirection));
					}
				}
			}

		}
	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static boolean checkMoveDirectionOnde(int x, int y) {

		for (int i = 0; i < CHECK_X.length; i++) {
			int moveX = x + CHECK_X[i];
			int moveY = y + CHECK_Y[i];

			if (array[moveX][moveY] == 1) {
				return false;
			}
		}

		return true;
	}

}

class Point {
	int x;
	int y;
	int direction;

	Point(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}