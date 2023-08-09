import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] MOVE_X = { 1, 0, -1, 0 };
	static int[] MOVE_Y = { 0, 1, 0, -1 };
	static int[] MOVE_HEIGHT = { 1, -1 };
	static int n;
	static int m;
	static int k;
	static int answer = 0;
	static List<int[][]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		m = Integer.parseInt(token.nextToken());
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		Deque<Point> q = new ArrayDeque<Point>();

		list = new ArrayList<>(k);

		for (int h = 0; h < k; h++) {
			int[][] array = new int[n][m];

			for (int i = 0; i < n; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++) {
					int tmp = Integer.parseInt(token.nextToken());
					array[i][j] = tmp;
					if (tmp == 1) {
						q.offer(new Point(i, j, h));

					}
				}
			}
			list.add(array);
		}

		BFS(q);

		System.out.println(lastCheck());

	}

	public static int lastCheck() {
		for (int h = 0; h < k; h++) {
			int[][] tmp = list.get(h);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (tmp[i][j] == 0) {
						return -1;
					}
				}
			}
		}
		return answer;
	}

	public static void BFS(Deque<Point> q) {

		int day = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Point p = q.pollFirst();

				int[][] tmp = list.get(p.height);
				for (int j = 0; j < MOVE_X.length; j++) {
					int moveX = p.x + MOVE_X[j];
					int moveY = p.y + MOVE_Y[j];

					if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < m && tmp[moveX][moveY] == 0) {
						tmp[moveX][moveY] = 1;
						q.offerLast(new Point(moveX, moveY, p.height));
					}
				}

				for (int j = 0; j < MOVE_HEIGHT.length; j++) {
					int moveHeight = p.height + MOVE_HEIGHT[j];

					if (moveHeight >= 0 && moveHeight < k) {
						tmp = list.get(moveHeight);
						if (tmp[p.x][p.y] == 0) {
							tmp[p.x][p.y] = 1;
							q.offerLast(new Point(p.x, p.y, moveHeight));
						}
					}
				}
			}
			if (q.isEmpty()) {
				break;
			}
			day++;
		}
		answer = day;
	}
}

class Point {

	int x;
	int y;
	int height;

	public Point(int x, int y, int height) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
	}
}