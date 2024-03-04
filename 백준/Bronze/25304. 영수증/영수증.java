import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		StringTokenizer token;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			sum += a * b;
		}
		String answer = "No";
		if (sum == x) {
			answer = "Yes";
		}
		System.out.println(answer);
	}
}