import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static String[] s;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < testCase; t++) {
			answer = Integer.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			s = br.readLine().split(" ");

			if (s.length > 32) {
				sb.append(0).append("\n");
			} else {
				Comb(0, 0, new String[3]);
				sb.append(answer).append("\n");
			}

		}
		System.out.println(sb);
	}

	public static void Comb(int start, int index, String[] pick) {
		if (index == pick.length) {
			int sum = 0;
			sum += compare(pick[0], pick[1]) + compare(pick[0], pick[2]) + compare(pick[1], pick[2]);
			answer = Math.min(answer, sum);

		} else {
			for (int i = start; i < s.length; i++) {
				pick[index] = s[i];
				Comb(i + 1, index + 1, pick);
			}
		}
	}

	public static int compare(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count;
	}

}