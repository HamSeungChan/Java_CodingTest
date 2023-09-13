import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] array1 = br.readLine().toCharArray();
		char[] array2 = br.readLine().toCharArray();

		int[][] dp = new int[array1.length + 1][array2.length + 1];

		for (int i = 1; i <= array1.length; i++) {
			for (int j = 1; j <= array2.length; j++) {
				if (array1[i - 1] == array2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}

				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[array1.length][array2.length]);
	}
}