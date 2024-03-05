import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] MOVE_X = {1, 0, -1, 0};
	static int[] MOVE_Y = {0, 1, 0, -1};

	static int n, m;
	static int[][] array;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		int time = 0;

		array = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
				if (array[i][j] == 1) {
					count++;
				}
			}
		}

		while (true) {
			List<Point> meltPoint = findMeltPoint();

			time++;
			if (meltPoint.size() == count) {
				StringBuilder sb = new StringBuilder();
				sb.append(time).append("\n");
				sb.append(count);
				System.out.println(sb);
				break;
			}

			for (Point point : meltPoint) {
				array[point.x][point.y] = 0;
				count--;
			}
		}
	}

	public static List<Point> findCheese() {
		List<Point> newCheese = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (array[i][j] == 1) {
					newCheese.add(new Point(i, j));
				}
			}
		}
		return newCheese;
	}

	public static List<Point> findMeltPoint() {

		List<Point> meltPoint = new ArrayList<>();
		boolean[][] check = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		check[0][0] = true;

		while (!q.isEmpty()) {
			Point tmp = q.poll();

			if (array[tmp.x][tmp.y] == 1) {
				meltPoint.add(tmp);
				continue;
			}

			for (int i = 0; i < MOVE_X.length; i++) {
				int moveX = tmp.x + MOVE_X[i];
				int moveY = tmp.y + MOVE_Y[i];
				if (canMove(moveX, moveY) && !check[moveX][moveY]) {
					check[moveX][moveY] = true;
					q.offer(new Point(moveX, moveY));
				}
			}
		}
		return meltPoint;
	}

	public static boolean canMove(int x, int y) {
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