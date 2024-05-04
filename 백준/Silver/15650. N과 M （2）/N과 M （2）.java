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

		comb(0, 0, new int[m]);
		System.out.print(sb);

	}

	public static void comb(int start, int index, int[] array) {

		if (index == m) {
			for (int i : array) {
				sb.append(i + 1).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = start; i < n; i++) {
				array[index] = i;
				comb(i + 1, index + 1, array);
			}
		}
	}
}