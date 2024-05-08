import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < test; i++) {

			int[] word = new int[26];
			int[] startIndex = new int[26];
			String s = br.readLine();
			int k = Integer.parseInt(br.readLine());

			int shortAnswer = Integer.MAX_VALUE;
			int longAnswer = Integer.MIN_VALUE;

			boolean flag = false;

			for (int j = 0; j < s.length(); j++) {

				int value = s.charAt(j) - 'a';

				if (word[value] == 0) {
					startIndex[value] = j;
				}
				word[value]++;

				if (word[value] > k) {
					for (int index = startIndex[value] + 1; index < j; index++) {
						if (s.charAt(index) - 'a' == value) {
							startIndex[value] = index;
							word[value]--;
							break;
						}
					}
				}

				if (word[value] == k) {
					flag = true;
					shortAnswer = Math.min(shortAnswer, j - startIndex[value] + 1);
					longAnswer = Math.max(longAnswer, j - startIndex[value] + 1);
				}
			}

			if (!flag) {
				sb.append(-1).append("\n");
				continue;
			}
			sb.append(shortAnswer).append(" ").append(longAnswer).append("\n");
		}
		System.out.print(sb);
	}
}