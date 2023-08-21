import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static final int[] MOVE_X = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static final int[] MOVE_Y = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static Point startPoint, endPoint;
	static boolean[][] check;
	static int[][] array;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int t = 0; t < testCase; t++) {
			n = Integer.parseInt(br.readLine());

			array = new int[n][n];
			check = new boolean[n][n];

			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(token.nextToken());
			int startY = Integer.parseInt(token.nextToken());
			startPoint = new Point(startX, startY);

			token = new StringTokenizer(br.readLine(), " ");
			int endX = Integer.parseInt(token.nextToken());
			int endY = Integer.parseInt(token.nextToken());
			endPoint = new Point(endX, endY);

			sb.append(bfs(startPoint, endPoint)).append("\n");
		}
		System.out.println(sb);
	}

	public static int bfs(Point startPoint, Point endPoint) {
		Queue<Point> q = new LinkedList<>();
		q.offer(startPoint);
		check[startPoint.x][startPoint.y] = true;
		int moveCount = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point tmp = q.poll();

				if (tmp.x == endPoint.x && tmp.y == endPoint.y) {
					return moveCount;
				}

				for (int j = 0; j < MOVE_X.length; j++) {
					int moveX = tmp.x + MOVE_X[j];
					int moveY = tmp.y + MOVE_Y[j];
					if (isValid(moveX, moveY) && check[moveX][moveY] == false) {
						check[moveX][moveY] = true;
						q.offer(new Point(moveX, moveY));
					}
				}
			}
			moveCount++;
		}
		return 0;
	}

	public static boolean isValid(int x, int y) {
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