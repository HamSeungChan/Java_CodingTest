import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] array;
	static int n, answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		array = new int[n];

		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}
		permutation(0, new boolean[n], new int[n]);
		System.out.println(answer);
	}

	public static void permutation(int index, boolean[] check, int[] pick) {

		if (index == n) {

			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				sum += Math.abs(pick[i] - pick[i + 1]);
			}
			answer = Math.max(sum, answer);

		} else {
			for (int i = 0; i < n; i++) {
				if (!check[i]) {
					pick[index] = array[i];
					check[i] = true;
					permutation(index + 1, check, pick);
					check[i] = false;
				}
			}
		}
	}
}