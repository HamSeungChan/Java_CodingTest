import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	static int[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		token = new StringTokenizer(br.readLine(), " ");
		number = new int[n];
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(number);
		permutation(new int [m], 0, 0);
		System.out.println(sb);
	}

	public static void permutation(int[] array, int count, int start) {
		if (count == m) {
			for (int x : array) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = start; i < number.length; i++) {
				array[count] = number[i];
				permutation(array, count + 1, i);
			}
		}
	}
}