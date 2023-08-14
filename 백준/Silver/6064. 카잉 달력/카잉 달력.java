import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer token;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < testCase; t++) {
			token = new StringTokenizer(br.readLine(), " ");

			int count = -1;

			int m = Integer.parseInt(token.nextToken());
			int n = Integer.parseInt(token.nextToken());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			int min = Math.min(m, n);
			int max = 0;

			for (int k = 1; k <= min; k++) {
				if (m % k == 0 && n % k == 0) {
					max = k;
				}
			}

			int maxCount = m * n / max;
			for (int k = x; k <= maxCount; k += m) {
				int tmp = k / n;

				if ((k - n * tmp) == y % n) {
					count = k;
					break;
				}
			}

			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}