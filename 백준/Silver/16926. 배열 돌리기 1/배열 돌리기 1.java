import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] MOVE_X = { 0, 1, 0, -1, 0 };
	static int[] MOVE_Y = { 1, 0, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int r = Integer.parseInt(token.nextToken());

		int[][] array = new int[n][m];
		boolean[][] check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		int tmp = Math.round(((float) (Math.min(n, m)) / 2));
		List<Deque<Integer>> list = new ArrayList<>();

		int startX = 0;
		int startY = 0;
		int tmpX = n;
		int tmpY = m;

		for (int i = 0; i < tmp; i++) {
			list.add(new ArrayDeque<>());
			Deque<Integer> d = list.get(i);

			int fullSize = tmpX * tmpY;
			tmpX -= 2;
			tmpY -= 2;
			int findSize = fullSize - tmpX * tmpY;

			int direction = 0;
			for (int j = 0; j < findSize; j++) {

				check[startX][startY] = true;
				d.addLast(array[startX][startY]);

				int moveX = startX + MOVE_X[direction];
				int moveY = startY + MOVE_Y[direction];

				if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= m || check[moveX][moveY]) {
					direction += 1;
					moveX = startX + MOVE_X[direction];
					moveY = startY + MOVE_Y[direction];
				}
				startX = moveX;
				startY = moveY;
			}

			startY++;
		}

		for (Deque<Integer> d : list) {
			for (int i = 0; i < r; i++) {
				d.addLast(d.pollFirst());
			}
		}

		startX = 0;
		startY = 0;
		tmpX = n;
		tmpY = m;
		check = new boolean[n][m];

		for (int i = 0; i < tmp; i++) {

			int fullSize = tmpX * tmpY;
			tmpX -= 2;
			tmpY -= 2;
			int findSize = fullSize - tmpX * tmpY;

			int direction = 0;
			for (int j = 0; j < findSize; j++) {

				Deque<Integer> q = list.get(i);

				array[startX][startY] = q.poll();
				check[startX][startY] = true;

				int moveX = startX + MOVE_X[direction];
				int moveY = startY + MOVE_Y[direction];

				if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= m || check[moveX][moveY]) {
					direction += 1;
					moveX = startX + MOVE_X[direction];
					moveY = startY + MOVE_Y[direction];
				}
				startX = moveX;
				startY = moveY;
			}

			startY++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}