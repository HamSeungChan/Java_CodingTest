import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] array;
	static List<CCTV> list;
	static int[][] check;
	static int answer = Integer.MAX_VALUE;
	static int blackPoint = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		array = new int[n][m];
		check = new int[n][m];
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(token.nextToken());
				array[i][j] = tmp;

				if (tmp > 0) {
					blackPoint++;
				}
				if (tmp > 0 && tmp < 6) {
					list.add(new CCTV(i, j, tmp));
				}
			}
		}

		DFS(0);
		System.out.println(answer - blackPoint);
	}

	public static int count() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check[i][j] == 0) {
					count++;
				}

			}
		}
		return count;
	}

	public static void DFS(int index) {
		if (index == list.size()) {

			for (CCTV cctv : list) {
				check[cctv.x][cctv.y] = 0;
			}

			answer = Math.min(answer, count());
		} else {
			CCTV cctv = list.get(index);
			int cctvType = cctv.type;
			int x = cctv.x;
			int y = cctv.y;

			if (cctvType == 1) {

				checkRight(x, y, true);
				DFS(index + 1);
				checkRight(x, y, false);

				checkLeft(x, y, true);
				DFS(index + 1);
				checkLeft(x, y, false);

				checkBottom(x, y, true);
				DFS(index + 1);
				checkBottom(x, y, false);

				checkTop(x, y, true);
				DFS(index + 1);
				checkTop(x, y, false);
			}

			else if (cctvType == 2) {

				checkTop(x, y, true);
				checkBottom(x, y, true);
				DFS(index + 1);
				checkTop(x, y, false);
				checkBottom(x, y, false);

				checkLeft(x, y, true);
				checkRight(x, y, true);
				DFS(index + 1);
				checkLeft(x, y, false);
				checkRight(x, y, false);
			}

			else if (cctvType == 3) {

				checkLeft(x, y, true);
				checkBottom(x, y, true);
				DFS(index + 1);
				checkLeft(x, y, false);
				checkBottom(x, y, false);

				checkLeft(x, y, true);
				checkTop(x, y, true);
				DFS(index + 1);
				checkLeft(x, y, false);
				checkTop(x, y, false);

				checkRight(x, y, true);
				checkTop(x, y, true);
				DFS(index + 1);
				checkRight(x, y, false);
				checkTop(x, y, false);

				checkRight(x, y, true);
				checkBottom(x, y, true);
				DFS(index + 1);
				checkRight(x, y, false);
				checkBottom(x, y, false);

			} else if (cctvType == 4) {

				checkRight(x, y, true);
				checkTop(x, y, true);
				checkLeft(x, y, true);
				DFS(index + 1);
				checkRight(x, y, false);
				checkTop(x, y, false);
				checkLeft(x, y, false);

				checkTop(x, y, true);
				checkRight(x, y, true);
				checkBottom(x, y, true);
				DFS(index + 1);
				checkTop(x, y, false);
				checkRight(x, y, false);
				checkBottom(x, y, false);

				checkRight(x, y, true);
				checkBottom(x, y, true);
				checkLeft(x, y, true);
				DFS(index + 1);
				checkRight(x, y, false);
				checkBottom(x, y, false);
				checkLeft(x, y, false);

				checkBottom(x, y, true);
				checkTop(x, y, true);
				checkLeft(x, y, true);
				DFS(index + 1);
				checkBottom(x, y, false);
				checkTop(x, y, false);
				checkLeft(x, y, false);

			} else {
				checkAll(x, y, true);
				DFS(index + 1);
				checkAll(x, y, false);
			}
		}
	}

	public static void checkAll(int x, int y, boolean plus) {
		checkRight(x, y, plus);
		checkLeft(x, y, plus);
		checkTop(x, y, plus);
		checkBottom(x, y, plus);
	}

	public static void checkRight(int x, int y, boolean plus) {

		int value = 1;
		if (!plus) {
			value = -1;
		}

		for (int i = y + 1; i < m; i++) {

			if (array[x][i] == 6) {
				break;
			}
			check[x][i] += value;
		}
	}

	public static void checkLeft(int x, int y, boolean plus) {

		int value = 1;
		if (!plus) {
			value = -1;
		}

		for (int i = y - 1; i >= 0; i--) {
			if (array[x][i] == 6) {
				break;
			}
			check[x][i] += value;
		}
	}

	public static void checkTop(int x, int y, boolean plus) {

		int value = 1;
		if (!plus) {
			value = -1;
		}

		for (int i = x - 1; i >= 0; i--) {
			if (array[i][y] == 6) {
				break;
			}
			check[i][y] += value;
		}
	}

	public static void checkBottom(int x, int y, boolean plus) {

		int value = 1;
		if (!plus) {
			value = -1;
		}

		for (int i = x + 1; i < n; i++) {
			if (array[i][y] == 6) {
				break;
			}
			check[i][y] += value;
		}
	}
}

class CCTV {
	int x;
	int y;
	int type;

	public CCTV(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}