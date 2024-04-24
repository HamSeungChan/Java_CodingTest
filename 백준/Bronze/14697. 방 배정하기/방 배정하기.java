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
		int c = Integer.parseInt(token.nextToken());
		int n = Integer.parseInt(token.nextToken());

		int maxA = n / a;
		int maxB = n / b;
		int maxC = n / c;

		int answer = 0;

		for (int i = 0; i <= maxA; i++) {
			for (int j = 0; j <= maxB; j++) {
				for (int k = 0; k <= maxC; k++) {
					if (i * a + j * b + k * c == n) {
						answer = 1;
					}
				}
			}
		}
		System.out.println(answer);
	}
}