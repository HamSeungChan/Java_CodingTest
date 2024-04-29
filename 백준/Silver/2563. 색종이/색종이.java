import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		boolean[][] array = new boolean[101][101];

		StringTokenizer token;
		for (int t = 0; t < n; t++) {

			token = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					array[i][j] = true;
				}
			}

		}

		int count = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (array[i][j])
					count++;

			}
		}

		System.out.println(count);
	}
}