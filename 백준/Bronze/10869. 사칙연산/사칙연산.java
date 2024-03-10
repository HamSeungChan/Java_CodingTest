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
		sb.append(a + b).append("\n");
		sb.append(a - b).append("\n");
		sb.append(a * b).append("\n");
		sb.append(a / b).append("\n");
		sb.append(a % b).append("\n");

		System.out.println(sb);
	}
}