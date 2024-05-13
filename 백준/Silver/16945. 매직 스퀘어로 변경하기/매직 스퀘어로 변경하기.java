import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		array = new int[3][3];

		StringTokenizer token;
		for (int i = 0; i < 3; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		permutation(0, 0, new boolean[10], new int[3][3]);
		System.out.println(answer);
	}

	public static void permutation(int i, int j, boolean[] check, int[][] values) {

		if (i == 3) {

			int diff = 0;
			if (checkMagicSquare(values)) {
				for (int a = 0; a < 3; a++) {
					for (int b = 0; b < 3; b++) {
						diff += Math.abs(array[a][b] - values[a][b]);
					}
				}
				answer = Math.min(answer, diff);
			}
			return;
		}

		for (int value = 1; value <= 9; value++) {
			if (!check[value]) {
				check[value] = true;
				values[i][j] = value;

				if (j + 1 == 3) {
					permutation(i + 1, 0, check, values);
				} else {
					permutation(i, j + 1, check, values);
				}

				check[value] = false;
			}
		}
	}

	public static boolean checkMagicSquare(int[][] values) {

		int leftCross = values[0][0] + values[1][1] + values[2][2];
		int rightCross = values[0][2] + values[1][1] + values[2][0];

		if (leftCross != rightCross) {
			return false;
		}

		// 가로 확인
		for (int i = 0; i < 3; i++) {
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += values[i][j];
			}
			if (leftCross != sum) {
				return false;
			}
		}

		// 세로 확인
		for (int i = 0; i < 3; i++) {
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += values[j][i];
			}
			if (leftCross != sum) {
				return false;
			}
		}

		return true;
	}

}