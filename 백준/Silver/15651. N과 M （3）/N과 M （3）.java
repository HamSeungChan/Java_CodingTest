import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.valueOf(token.nextToken());
		m = Integer.valueOf(token.nextToken());
		permutaion(new int[m], 0);
		System.out.println(sb.toString());
	}

	public static void permutaion(int[] array, int count) {
		if (count == m) {
			for (int x : array) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				array[count] = i;
				permutaion(array, count + 1);
			}
		}
	}
}