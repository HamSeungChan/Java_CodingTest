import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int m;
	static int[] array;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			sb.append("#").append(t).append(" ");
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			answer = -1;
			array = new int[n];
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(token.nextToken());
			}
			Comb(0, 0, 0);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	public static void Comb(int count, int start, int sum) {

		if (sum > m) {
			return;
		}

		if (count == 2) {
			answer = Math.max(sum, answer);
		} else {
			for (int i = start; i < n; i++) {
				sum += array[i];
				Comb(count + 1, i + 1, sum);
				sum -= array[i];
			}
		}
	}

}