import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, s, answer = 0;
	static int[] array;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		s = Integer.parseInt(token.nextToken());

		array = new int[n];
		token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(token.nextToken());
		}

		subset(new boolean[n], 0, 0);
		System.out.println(answer);
	}

	public static void subset(boolean[] pick, int count, int index) {
		if (index == n) {

			if (count == 0) {
				return;
			}

			int sum = 0;
			for (int i = 0; i < pick.length; i++) {
				if (pick[i])
					sum += array[i];
			}

			if (sum == s) {
				answer++;
			}

		} else {

			// 사용
			pick[index] = true;
			subset(pick, count + 1, index + 1);

			// 사용하지 않음
			pick[index] = false;
			subset(pick, count, index + 1);

		}
	}
}