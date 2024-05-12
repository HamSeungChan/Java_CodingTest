import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int n, k, answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());

		array = new int[n][n];

		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		if (k == 1) {
			System.out.println(0);
		} else {
			comb(0, 0, new int[k]);
			System.out.println(answer);
		}

	}

	public static void comb(int index, int start, int[] pick) {
		if (index == k) {
			int value = 0;
			for (int i = 0; i < pick.length; i++) {
				for (int j = i + 1; j < pick.length; j++) {
					value += array[pick[i]][pick[j]];
				}
			}
			answer = Math.max(value, answer);
			return;
		}

		for (int i = start; i < n; i++) {
			pick[index] = i;
			comb(index + 1, i + 1, pick);
		}
	}

}