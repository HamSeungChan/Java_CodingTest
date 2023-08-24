import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int d = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		int c = Integer.parseInt(token.nextToken());

		int answer = 0;
		int[] chobab = new int[n];
		for (int i = 0; i < n; i++) {
			chobab[i] = Integer.parseInt(br.readLine());
		}

		int[] pick = new int[d + 1];
		pick[c]++;
		int count = 1;
		for (int i = 0; i < k; i++) {
			if (pick[chobab[i]] == 0) {
				count++;
			}
			pick[chobab[i]]++;
		}

		answer = Integer.max(answer, count);

		for (int i = 1; i < n; i++) {
			pick[chobab[i - 1]]--;
			if (pick[chobab[i - 1]] == 0) {
				count--;
			}
			
			if (pick[chobab[(i + k - 1) % n]] == 0) {
				count++;
			}
			pick[chobab[(i + k - 1) % n]]++;
			
			answer = Integer.max(answer, count);
		}
		
		System.out.println(answer);
	}

}