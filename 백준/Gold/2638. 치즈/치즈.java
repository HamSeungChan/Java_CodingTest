import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] MOVE_X = { 1, 0, -1, 0 };
	static int[] MOVE_Y = { 0, 1, 0, -1 };
	static int n, m;
	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		array = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		int time = 0;
		while (true) {
			if (!BFS(new Point(0, 0))) {
				break;
			}
			time++;
		}

		System.out.println(time);

	}

	public static boolean BFS(Point p) {
		boolean[][] check = new boolean[n][m];
		int[][] cheeseCount = new int[n][m];
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		check[p.x][p.y] = true;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			for (int i = 0; i < MOVE_X.length; i++) {
				int moveX = tmp.x + MOVE_X[i];
				int moveY = tmp.y + MOVE_Y[i];

				if (isRange(moveX, moveY) && array[moveX][moveY] == 1) {
					cheeseCount[moveX][moveY]++;
				}

				if (isRange(moveX, moveY) && array[moveX][moveY] == 0 && !check[moveX][moveY]) {
					check[moveX][moveY] = true;
					q.add(new Point(moveX, moveY));
				}
			}
		}

		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (array[i][j] == 0) {
					count++;
				}

				if (cheeseCount[i][j] >= 2) {
					array[i][j] = 0;
				}
			}
		}

		if (count == n * m) {
			return false;
		}
		return true;
	}

	public static boolean isRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
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