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

		StringBuilder sb = new StringBuilder();

		for (int i = -1000; i <= 1000; i++) {
			if (i * i + 2 * a * i + b == 0) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}
}