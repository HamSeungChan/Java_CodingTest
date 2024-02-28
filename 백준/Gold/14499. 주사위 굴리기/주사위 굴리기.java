import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] MOVE_X = {0, 0, 0, -1, 1};
	static int[] MOVE_Y = {0, 1, -1, 0, 0};
	static int n, m;
	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		int x = Integer.parseInt(token.nextToken());
		int y = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());

		int[] vertical = new int[4];
		int[] horizon = new int[4];
		int verticalTopIndex = 1;
		int horizonTopIndex = 1;

		array = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			int moveDirection = Integer.parseInt(token.nextToken());
			int moveX = x + MOVE_X[moveDirection];
			int moveY = y + MOVE_Y[moveDirection];
			if (check(moveX, moveY)) {
				int[] move = move(moveDirection, vertical, horizon, horizonTopIndex
					, verticalTopIndex, moveX, moveY);
				verticalTopIndex = move[0];
				horizonTopIndex = move[1];
				sb.append(vertical[verticalTopIndex]).append("\n");
				x = moveX;
				y = moveY;
			}
		}
		System.out.println(sb);
	}

	public static boolean check(int moveX, int moveY) {
		return moveX >= 0 && moveX < n && moveY >= 0 && moveY < m;
	}

	public static int[] move(int moveDirection, int[] vertical, int[] horizon
		, int horizonTopIndex, int verticalTopIndex, int x, int y) {

		/*
		 * 1 -> 동쪽
		 * 2 -> 서쪽
		 * 3 -> 븍쪽
		 * 4 -> 남쪽
		 * */

		if (moveDirection == 1) {
			horizonTopIndex = (horizonTopIndex - 1 + 4) % 4;
			if (array[x][y] == 0) {
				array[x][y] = horizon[(horizonTopIndex + 2) % 4];
			} else {
				horizon[(horizonTopIndex + 2) % 4] = array[x][y];
				array[x][y] = 0;
			}
			vertical[verticalTopIndex] = horizon[horizonTopIndex];
			vertical[(verticalTopIndex + 2) % 4] = horizon[(horizonTopIndex + 2) % 4];
		} else if (moveDirection == 2) {
			horizonTopIndex = (horizonTopIndex + 1) % 4;
			if (array[x][y] == 0) {
				array[x][y] = horizon[(horizonTopIndex + 2) % 4];
			} else {
				horizon[(horizonTopIndex + 2) % 4] = array[x][y];
				array[x][y] = 0;
			}
			vertical[verticalTopIndex] = horizon[horizonTopIndex];
			vertical[(verticalTopIndex + 2) % 4] = horizon[(horizonTopIndex + 2) % 4];
		} else if (moveDirection == 3) {
			verticalTopIndex = (verticalTopIndex + 1) % 4;
			if (array[x][y] == 0) {
				array[x][y] = vertical[(verticalTopIndex + 2) % 4];
			} else {
				vertical[(verticalTopIndex + 2) % 4] = array[x][y];
				array[x][y] = 0;
			}
			horizon[horizonTopIndex] = vertical[verticalTopIndex];
			horizon[(horizonTopIndex + 2) % 4] = vertical[(verticalTopIndex + 2) % 4];
		} else {
			verticalTopIndex = (verticalTopIndex - 1 + 4) % 4;
			if (array[x][y] == 0) {
				array[x][y] = vertical[(verticalTopIndex + 2) % 4];
			} else {
				vertical[(verticalTopIndex + 2) % 4] = array[x][y];
				array[x][y] = 0;
			}
			horizon[horizonTopIndex] = vertical[verticalTopIndex];
			horizon[(horizonTopIndex + 2) % 4] = vertical[(verticalTopIndex + 2) % 4];
		}
		return new int[] {verticalTopIndex, horizonTopIndex};
	}
}