import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] MOVE_X = {1, 0};
	static int[] MOVE_Y = {0, 1};
	static int[][] array;
	static long[][] check;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		array = new int[n][n];
		check = new long[n][n];
		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
				check[i][j] = -1;
			}
		}

		System.out.println(move(new Point(0, 0)));
	}

	public static long move(Point p) {

		if (p.x == n - 1 && p.y == n - 1) {
			return 1;
		}
		if (check[p.x][p.y] != -1) {
			return check[p.x][p.y];
		}

		check[p.x][p.y] = 0;
		for (int i = 0; i < MOVE_X.length; i++) {
			int moveX = p.x + MOVE_X[i] * array[p.x][p.y];
			int moveY = p.y + MOVE_Y[i] * array[p.x][p.y];
			if (canMove(moveX, moveY)) {
				check[p.x][p.y] += move(new Point(moveX, moveY));
			}
		}
		return check[p.x][p.y];
	}

	public static boolean canMove(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}