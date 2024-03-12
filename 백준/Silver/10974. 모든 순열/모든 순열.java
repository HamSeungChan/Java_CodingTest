import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		permutation(new int[n], 0, new boolean[n + 1]);
		System.out.println(sb);
	}

	public static void permutation(int[] array, int index, boolean[] check) {
		if (index == n) {
			for (int i : array) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				array[index] = i;
				if (!check[i]) {
					check[i] = true;
					permutation(array, index + 1, check);
					check[i] = false;
				}
			}
		}
	}
}