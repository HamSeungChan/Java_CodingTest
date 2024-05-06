import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] members;
	static int n, answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		members = new int[n][5];

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				members[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		permutation(0, new int[5], new boolean[5]);
		System.out.println(answer);
	}

	public static void permutation(int index, int[] array, boolean[] check) {
		if (index == 5) {

			int sum = 0;
			boolean[] use = new boolean[n];

			for (int i = 0; i < 5; i++) {
				int tmp = array[i];
				int max = Integer.MIN_VALUE;
				int maxIndex = -1;
				for (int j = 0; j < n; j++) {
					if (!use[j] && max < members[j][tmp]) {
						max = members[j][tmp];
						maxIndex = j;
					}
				}
				use[maxIndex] = true;
				sum += max;
			}

			answer = Math.max(sum, answer);

		} else {
			for (int i = 0; i < 5; i++) {
				if (!check[i]) {
					check[i] = true;
					array[index] = i;
					permutation(index + 1, array, check);
					check[i] = false;
				}
			}
		}
	}

}