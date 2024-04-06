import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int n, q;
	public static int[][] map;
	public static int[] mx = {-1, 1, 0, 0};
	public static int[] my = {0, 0, -1, 1};
	public static int answer, totalIce;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		n = Integer.parseInt(token.nextToken());
		q = Integer.parseInt(token.nextToken());

		n = (int)Math.pow(2, n);
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		token = new StringTokenizer(br.readLine());
		int[] level = new int[q];
		for (int i = 0; i < q; i++) {
			level[i] = Integer.parseInt(token.nextToken());
		}

		for (int i = 0; i < q; i++) {

			map = divide(level[i]);
			map = melt();
		}
		answer = 0;
		totalIce = 0;

		biggest();
		System.out.println(totalIce);
		System.out.println(answer);

	}

	public static int[][] divide(int L) {
		int[][] tmp = new int[n][n];
		L = (int)Math.pow(2, L);
		for (int i = 0; i < n; i += L) {
			for (int j = 0; j < n; j += L) {
				rotate(i, j, L, tmp);
			}
		}
		return tmp;

	}

	public static void rotate(int x, int y, int level, int[][] tmp) {
		for (int i = 0; i < level; i++) {
			for (int j = 0; j < level; j++) {
				tmp[x + i][y + j] = map[x + level - 1 - j][y + i];
			}
		}
	}

	public static int[][] melt() {
		int[][] tmp = new int[n][n];
		for (int i = 0; i < n; i++) {
			tmp[i] = Arrays.copyOf(map[i], n);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++) {
					int nx = i + mx[k];
					int ny = j + my[k];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
						if (map[nx][ny] > 0) {
							cnt++;
						}
					}
				}
				if (cnt < 3)
					tmp[i][j]--;
			}
		}
		return tmp;
	}

	public static void biggest() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				totalIce += map[i][j];
				if (map[i][j] > 0 && !visit[i][j]) {
					q.add(new int[] {i, j});
					visit[i][j] = true;
					int cnt = 1;

					while (!q.isEmpty()) {
						int[] t = q.poll();
						int tx = t[0];
						int ty = t[1];

						for (int k = 0; k < 4; k++) {
							int nx = tx + mx[k];
							int ny = ty + my[k];
							if (canMove(nx, ny)) {
								if (map[nx][ny] > 0 && !visit[nx][ny]) {
									visit[nx][ny] = true;
									q.add(new int[] {nx, ny});
									cnt++;
								}
							}
						}

					}
					answer = Math.max(answer, cnt);
				}
			}
		}
	}

	public static boolean canMove(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}