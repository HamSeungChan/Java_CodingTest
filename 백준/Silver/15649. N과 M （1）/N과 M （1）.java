import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		permutation(new int[m], new boolean[n + 1], 0);
		System.out.println(sb);
	}

	public static void permutation(int[] array, boolean[] check, int index) {
		if (index == m) {
			for (int i : array) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				if (!check[i]) {
					array[index] = i;
					check[i] = true;
					permutation(array, check, index + 1);
					check[i] = false;
				}
			}
		}
	}
}