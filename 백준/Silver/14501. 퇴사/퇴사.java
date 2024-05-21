import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int n, answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		array = new int[n + 1][2];

		StringTokenizer token;
		for (int i = 1; i <= n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(token.nextToken());
			array[i][1] = Integer.parseInt(token.nextToken());
		}

		recursion(1, 0, 0);
		System.out.println(answer);
	}

	public static void recursion(int day, int sum, int working) {

		if (day == n + 1) {
			answer = Math.max(answer, sum);
			return;
		}

		// 선택하는 경우
		if (working <= 0 && array[day][0] + day <= n + 1) {
			recursion(day + 1, sum + array[day][1], array[day][0] - 1);
		}
		// 선택하지 않는 경우
		recursion(day + 1, sum, working - 1);
	}
}