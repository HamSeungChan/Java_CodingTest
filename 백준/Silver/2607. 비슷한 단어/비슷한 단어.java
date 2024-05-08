import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String first = br.readLine();

		int answer = 0;

		for (int i = 0; i < n - 1; i++) {
			String str = br.readLine();
			int cnt = 0;
			int[] word = new int[26];
			for (int j = 0; j < first.length(); j++) {
				word[first.charAt(j) - 'A']++;
			}

			for (int j = 0; j < str.length(); j++) {
				if (word[str.charAt(j) - 'A'] > 0) {
					cnt++;
					word[str.charAt(j) - 'A']--;
				}
			}

			// 차이가 없거나 하나
			if (first.length() == str.length() && (first.length() == cnt || first.length() - 1 == cnt)) {
				answer++;
			}
			// 하나 더 많은 경우 
			else if (first.length() + 1 == str.length() && str.length() - 1 == cnt) {
				answer++;
			}

			// 본인은 일단 다 있어야 한다!
			else if (first.length() - 1 == str.length() && str.length() == cnt) {
				answer++;
			}

		}
		System.out.println(answer);

	}
}