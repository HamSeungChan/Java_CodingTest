import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] ladder;
	static int n, h, answer = Integer.MAX_VALUE;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		h = Integer.parseInt(token.nextToken());

		ladder = new boolean[h + 1][n + 2];

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			ladder[a][b] = true;
		}

		recursive(1, 1, 0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	public static void recursive(int x, int y, int pickCount) {

		if (flag) {
			return;
		}

		if (pickCount > 3) {
			return;
		}

		if (x == h + 1) {
			int check = 0;
			for (int i = 1; i <= n; i++) {
				int value = i;
				for (int j = 1; j <= h; j++) {
					// 왼쪽 녀석과 연결
					if (value > 1 && ladder[j][value - 1]) {
						value = value - 1;
						continue;
					}
					// 오른쪽 녀석과 연결
					if (value < n && ladder[j][value]) {
						value = value + 1;
					}
				}
				if (value == i) {
					check++;
				}
			}

			if (check == n) {
				answer = Math.min(pickCount, answer);
			}

			return;
		}

		int nextX = x;
		int nextY = y + 1;

		if (nextY == n + 1) {
			nextX += 1;
			nextY = 1;
		}

		// 이미 다리가 있는 경우 && 가장 끝 다리에 왔을 떄
		if (ladder[x][y] || y == n) {
			recursive(nextX, nextY, pickCount);
			return;
		}

		// 선택하지 않는 경우
		recursive(nextX, nextY, pickCount);

		// 선택한 경우
		// 우선 다리를 놓을 수 있는 지 부터 확인
		if (canMake(x, y)) {
			ladder[x][y] = true;
			recursive(x, y, pickCount + 1);
			ladder[x][y] = false;
		}
	}

	public static boolean canMake(int x, int y) {

		// 왼쪽
		if (ladder[x][y - 1]) {
			return false;
		}
		// 오른쪽 확인
		if (ladder[x][y + 1]) {
			return false;
		}
		return true;
	}

}