import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] number;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());

		number = new int[n];
		token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			number[i] = Integer.valueOf(token.nextToken());
		}
		Arrays.sort(number);

		combination(new int[m], new int[n], 0, 0);
		System.out.println(sb);
	}

	public static void combination(int[] array, int[] check, int count, int start) {
		if (count == m) {
			for (int x : array) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = start; i < number.length; i++) {
				array[count] = number[i];
				combination(array, check, count + 1, i + 1);

			}
		}
	}

}