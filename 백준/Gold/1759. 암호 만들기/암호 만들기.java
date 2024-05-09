import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean[] alphabet = new boolean[26];
	static int l, c;
	static String[] s;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		// 모음 다 true로
		alphabet['a' - 'a'] = true;
		alphabet['e' - 'a'] = true;
		alphabet['i' - 'a'] = true;
		alphabet['o' - 'a'] = true;
		alphabet['u' - 'a'] = true;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		l = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());

		s = br.readLine().split(" ");
		Arrays.sort(s);

		subset(0, 0, new boolean[c]);
		System.out.print(sb);
	}

	public static void subset(int index, int pick, boolean[] use) {

		if (pick == l) {

			int moeumCount = 0;
			int jaeumCount = 0;

			for (int i = 0; i < c; i++) {
				if (use[i]) {
					// 모음 이라면
					if (alphabet[s[i].charAt(0) - 'a']) {
						moeumCount++;
						continue;
					}
					jaeumCount++;
				}
			}

			if (moeumCount >= 1 && jaeumCount >= 2) {
				for (int i = 0; i < use.length; i++) {
					if (use[i]) {
						sb.append(s[i].charAt(0));
					}
				}
				sb.append("\n");
			}
			return;
		}

		if (index == c)
			return;

		// 사용하는 경우
		use[index] = true;
		subset(index + 1, pick + 1, use);

		// 사용하지 않는다
		use[index] = false;
		subset(index + 1, pick, use);
	}
}