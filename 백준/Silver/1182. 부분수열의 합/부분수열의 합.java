import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] array;
	static int n, s, answer = 0;

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
		subset(0, 0, 0);
		System.out.println(answer);
	}

	public static void subset(int index, int pick, int sum) {

		if (index == n) {
			if (sum == s && pick > 0) {
				answer++;
			}

		} else {
			// 선택하지 않은 경우
			subset(index + 1, pick, sum);

			// 선택한 경우
			subset(index + 1, pick + 1, sum + array[index]);
		}
	}
}