import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		int[] canSee = new int[n];

		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}

		for (int i = 0; i < n - 1; i++) {

			canSee[i]++;
			canSee[i + 1]++;

			double gak = (double)(array[i + 1] - array[i]);

			for (int j = i + 2; j < n; j++) {

				double nextGak = (double)(array[j] - array[i]) / (j - i);
				if (nextGak <= gak) {
					continue;
				}
				gak = nextGak;
				canSee[i]++;
				canSee[j]++;
			}

		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			answer = Math.max(canSee[i], answer);
		}
		System.out.println(answer);
	}
}