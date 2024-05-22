import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int answer = 0;
	static int[][] array;
	static boolean[][] pick, check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		array = new int[8][7];
		check = new boolean[8][7];
		pick = new boolean[7][7];

		for (int i = 0; i < 8; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < 7; j++) {
				array[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		recursive(0, 0);
		System.out.println(answer);
	}

	public static void recursive(int x, int y) {

		if (x == 8) {
			answer++;
			return;
		}

		int nextX = x;
		int nextY = y + 1;

		if (nextY == 7) {
			nextX++;
			nextY = 0;
		}

		if (check[x][y]) {
			recursive(nextX, nextY);
			return;
		}
		// 가로
		if (y < 6 && !check[x][y + 1]) {

			int min = Math.min(array[x][y], array[x][y + 1]);
			int max = Math.max(array[x][y], array[x][y + 1]);

			if (min <= max && !pick[min][max]) {
				pick[min][max] = true;
				check[x][y] = true;
				check[x][y + 1] = true;
				recursive(nextX, nextY);
				pick[min][max] = false;
				check[x][y] = false;
				check[x][y + 1] = false;
			}
		}
		// 세로
		if (x < 7 && !check[x + 1][y]) {
			int min = Math.min(array[x][y], array[x + 1][y]);
			int max = Math.max(array[x][y], array[x + 1][y]);

			if (min <= max && !pick[min][max]) {
				pick[min][max] = true;
				check[x][y] = true;
				check[x + 1][y] = true;
				recursive(nextX, nextY);
				pick[min][max] = false;
				check[x][y] = false;
				check[x + 1][y] = false;
			}
		}
	}

}