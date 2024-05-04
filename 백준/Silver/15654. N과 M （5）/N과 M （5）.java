import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] array;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		array = new int[n];

		token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}

		Arrays.sort(array);

		permutation(0, new boolean[n], new int[m]);
		System.out.print(sb);

	}

	public static void permutation(int index, boolean[] check, int[] pick) {
		if (index == m) {
			for (int i : pick) {
				sb.append(array[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 0; i < n; i++) {
				if (!check[i]) {
					pick[index] = i;
					check[i] = true;
					permutation(index + 1, check, pick);
					check[i] = false;
				}
			}
		}
	}
}