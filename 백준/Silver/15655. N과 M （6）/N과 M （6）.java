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

		comb(0, 0, new int[m]);
		System.out.print(sb);

	}

	public static void comb(int index, int start, int[] pick) {
		if (index == m) {

			for (int i : pick) {
				sb.append(array[i]).append(" ");
			}
			sb.append("\n");

		} else {
			for (int i = start; i < n; i++) {
				pick[index] = i;
				comb(index + 1, i + 1, pick);
			}
		}
	}
}