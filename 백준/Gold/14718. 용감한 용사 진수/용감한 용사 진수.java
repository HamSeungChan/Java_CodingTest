import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());

		int[] first = new int[n];
		int[] second = new int[n];
		int[] third = new int[n];

		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			first[i] = Integer.parseInt(token.nextToken());
			second[i] = Integer.parseInt(token.nextToken());
			third[i] = Integer.parseInt(token.nextToken());
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int r = 0; r < n; r++) {

					// 이길 수 있는 병사의 수
					int canWin = 0;
					for (int x = 0; x < n; x++) {
						if (first[i] >= first[x] && second[j] >= second[x] && third[r] >= third[x]) {
							canWin++;

						}
					}
					if (canWin >= k) {
						answer = Math.min(answer, first[i] + second[j] + third[r]);
					}
				}
			}
		}
		System.out.println(answer);
	}

}