import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[][] array;
	static boolean[][] pipeLine;
	static int answer, r, c;
	static boolean flag;
	static final int[] MOVE_X = { -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());

		pipeLine = new boolean[r][c];
		array = new char[r][c];
		answer = 0;

		for (int i = 0; i < r; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < c; j++) {
				array[i][j] = tmp.charAt(j);
			}
		}

		for (int i = 0; i < r; i++) {
			flag = false;
			setPipe(i, 0);
		}

		System.out.println(answer);

	}

	public static void setPipe(int x, int y) {

		if (y == c - 1) {
			answer++;
			flag = true;
			return;
		}

		for (int i = 0; i < MOVE_X.length; i++) {
			int moveX = x + MOVE_X[i];
			int moveY = y + 1;
			if (checkValid(moveX, moveY)) {
				pipeLine[moveX][moveY] = true;
				setPipe(moveX, moveY);
				if (flag) {
					break;
				}
			}
		}
	}

	public static boolean checkValid(int x, int y) {
		if (x >= 0 && x < r && array[x][y] != 'x' && pipeLine[x][y] == false) {
			return true;
		}
		return false;
	}

}