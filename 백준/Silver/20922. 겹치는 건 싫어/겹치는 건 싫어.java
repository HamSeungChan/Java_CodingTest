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

		int[] array = new int[n];
		int[] check = new int[100001];

		token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}

		int answer = 0, lt = 0;
		for (int rt = 0; rt < n; rt++) {

			int tmp = array[rt];
			check[tmp]++;
			if (check[tmp] > k) {
				while (true) {
					if (array[lt] == tmp) {
						break;
					}
					check[array[lt]]--;
					lt++;
				}
				lt++;
				check[tmp]--;
			}
			// k개 이하일 경우
			answer = Math.max(answer, rt - lt + 1);
		}

		System.out.println(answer);

	}
}