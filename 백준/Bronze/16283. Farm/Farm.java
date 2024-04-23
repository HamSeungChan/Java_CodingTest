import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(token.nextToken());
		int b = Integer.parseInt(token.nextToken());
		int n = Integer.parseInt(token.nextToken());
		int w = Integer.parseInt(token.nextToken());

		int answerCount = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < n; i++) {
			if (i * a + (n - i) * b == w) {
				sb.append(i).append(" ").append(n - i);
				answerCount++;
			}

			if (answerCount > 1) {
				break;
			}
		}

		if (answerCount != 1) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
	}
}