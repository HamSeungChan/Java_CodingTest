import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] hitter;
	static boolean[] check;
	static int n, base, answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		hitter = new int[n + 1][10];
		check = new boolean[10];

		for (int i = 1; i <= n; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				hitter[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		int[] array = new int[10];
		array[4] = 1;
		check[1] = true;

		permutation(1, array);
		System.out.println(answer);
	}

	public static void permutation(int index, int[] array) {
		if (index == 10) {

			base = 0;
			int score = 0;
			int inning = 1;
			int order = 1;
			int outCount = 0;

			while (true) {
				int hitterAnta = hitter[inning][array[order++]];

				if (hitterAnta == 0) {
					outCount++;
					if (outCount == 3) {
						inning++;
						outCount = 0;
						base = 0;

						if (inning == n + 1) {
							break;
						}

					}
				} else {
					score += move(hitterAnta);
				}

				if (order == 10) {
					order = 1;
				}
			}

			answer = Math.max(answer, score);

		} else {
			for (int i = 1; i <= 9; i++) {
				if (index == 4) {
					index++;
				}
				if (check[i] == false) {
					check[i] = true;
					array[index] = i;
					permutation(index + 1, array);
					check[i] = false;

				}
			}
		}
	}

	public static int move(int hit) {

		if (hit == 4) {
			int score = Integer.bitCount(base) + 1;
			base = 0;
			return score;
		}

		base = base << hit;
		int score = Integer.bitCount(base & 56);
		base = base & 7;
		base += 1 << (hit - 1);

		return score;
	}

}