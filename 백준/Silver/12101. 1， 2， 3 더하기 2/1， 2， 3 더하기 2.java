import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k, answerCount = 0;
	static boolean flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());

		permutation(0, new int[n], 0);
		if (answerCount < k) {
			System.out.println(-1);
		} else {
			System.out.print(sb);
		}
	}

	public static void permutation(int index, int[] array, int sum) {

		if (sum == n || index == n) {
			if (sum != n) {
				return;
			}
			answerCount++;
			if (answerCount == k) {
				flag = true;
				sb.append(array[0]);
				for (int i = 1; i < index; i++) {
					sb.append("+").append(array[i]);
				}
			}

		} else {
			for (int i = 1; i <= 3; i++) {
				array[index] = i;
				permutation(index + 1, array, sum + i);
			}
		}
	}
}