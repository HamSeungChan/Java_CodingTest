import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int n;
	static boolean[][] check;
	static List<Point> list = new ArrayList<>();
	static int[] MOVE_X = {1, 0, -1, 0};
	static int[] MOVE_Y = {0, 1, 0, -1};
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = new int[n][n];
		check = new boolean[n][n];

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		int count = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (array[i][j] == 1 && !check[i][j]) {
					bfs(new Point(i, j), count);
					count++;
				}
			}
		}

		for (Point point : list) {
			answer = Math.min(answer, bfs(point));
		}
		System.out.println(answer);
	}

	public static void bfs(Point p, int count) {
		Queue<Point> q = new LinkedList<>();
		q.offer(p);
		check[p.x][p.y] = true;
		array[p.x][p.y] = count;

		while (!q.isEmpty()) {
			Point tmp = q.poll();
			list.add(tmp);
			for (int i = 0; i < MOVE_X.length; i++) {
				int moveX = tmp.x + MOVE_X[i];
				int moveY = tmp.y + MOVE_Y[i];
				if (inRange(moveX, moveY) && !check[moveX][moveY] && array[moveX][moveY] == 1) {
					q.offer(new Point(moveX, moveY));
					check[moveX][moveY] = true;
					array[moveX][moveY] = count;
				}
			}
		}
	}

	public static int bfs(Point p) {
		int startValue = array[p.x][p.y];
		boolean[][] check = new boolean[n][n];
		check[p.x][p.y] = true;
		int depth = 0;

		Queue<Point> q = new LinkedList<>();
		q.offer(p);

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point tmp = q.poll();
				for (int i = 0; i < MOVE_X.length; i++) {
					int moveX = tmp.x + MOVE_X[i];
					int moveY = tmp.y + MOVE_Y[i];
					if (inRange(moveX, moveY) && array[moveX][moveY] != startValue && !check[moveX][moveY]) {
						if (array[moveX][moveY] > 0) {
							return depth;
						}
						check[moveX][moveY] = true;
						q.offer(new Point(moveX, moveY));
					}
				}
			}
			depth++;
		}
		return Integer.MAX_VALUE;
	}

	public static boolean inRange(int x, int y) {
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