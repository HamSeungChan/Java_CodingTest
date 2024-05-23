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

		int result = a ^ b;
		for (int i = 0; i < c - 1; i++) {
			result = result ^ b;
		}
		System.out.println(result);
	}

}