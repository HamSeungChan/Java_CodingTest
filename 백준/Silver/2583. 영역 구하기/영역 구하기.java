import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] array;
	static int[] MOVE_X = { 1, 0, -1, 0 };
	static int[] MOVE_Y = { 0, 1, 0, -1 };
	static int m, n;;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		m = Integer.parseInt(token.nextToken());
		n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());

		array = new boolean[m][n];

		for (int i = 0; i < k; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(token.nextToken());
			int startY = Integer.parseInt(token.nextToken());
			int endX = Integer.parseInt(token.nextToken());
			int endY = Integer.parseInt(token.nextToken());
			paperPut(startX, startY, endX, endY);
		}

		int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!array[i][j]) {
					answer++;
					q.offer(countBlank(i, j));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(answer).append("\n");
		while (!q.isEmpty()) {
			sb.append(q.poll()).append(" ");
		}
		System.out.println(sb);

	}

	static int countBlank(int x, int y) {

		int count = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		array[x][y] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			count++;

			for (int i = 0; i < MOVE_X.length; i++) {
				int moveX = tmp[0] + MOVE_X[i];
				int moveY = tmp[1] + MOVE_Y[i];
				if (canMove(moveX, moveY)) {
					q.offer(new int[] { moveX, moveY });
					array[moveX][moveY] = true;
				}
			}
		}

		return count;

	}

	static void paperPut(int startX, int startY, int endX, int endY) {
		for (int i = m - endY; i <= m - 1 - startY; i++) {
			for (int j = startX; j <= endX - 1; j++) {
				array[i][j] = true;
			}
		}
	}

	static boolean canMove(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n && !array[x][y];
	}

}