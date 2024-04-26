import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = new int[n][3];

		StringTokenizer token;

		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		int count = 0;

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (i == j)
					continue;
				for (int k = 1; k <= 9; k++) {
					if (i == k || j == k)
						continue;
					if (check(i, j, k)) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	public static boolean check(int first, int second, int third) {

		boolean[] use = new boolean[10];

		use[first] = true;
		use[second] = true;
		use[third] = true;

		for (int i = 0; i < n; i++) {

			int strikeCount = 0;
			int ballCount = 0;

			int tmp = array[i][0];
			// 자릿수 별로 사용되었는지 확인한다.
			if (use[tmp / 100]) {
				if (first != tmp / 100) {
					ballCount++;
				} else {
					strikeCount++;
				}
			}

			if (use[(tmp % 100) / 10]) {
				if (second != (tmp % 100) / 10) {
					ballCount++;
				} else {
					strikeCount++;
				}
			}

			if (use[tmp % 10]) {
				if (third != tmp % 10) {
					ballCount++;
				} else {
					strikeCount++;
				}
			}

			if (strikeCount != array[i][1] || ballCount != array[i][2]) {
				return false;
			}
		}

		return true;
	}

}