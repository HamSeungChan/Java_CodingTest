import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static String[] s;
	static Set<String> set;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		// 모음을 set에 담아준다.
		set = new HashSet<>();
		set.add("a");
		set.add("e");
		set.add("i");
		set.add("o");
		set.add("u");

		int l = Integer.parseInt(token.nextToken());
		int c = Integer.parseInt(token.nextToken());

		s = br.readLine().split(" ");
		Arrays.sort(s);
		
		setPassword(new String[l], 0 ,0);
		System.out.print(sb);
	}

	public static void setPassword(String[] tmp, int index, int start) {
		if (index == tmp.length) {

			int countMoem = 0;
			int countZaeum = 0;
			StringBuilder b = new StringBuilder();

			for (String s : tmp) {
				b.append(s);
				if (set.contains(s)) {
					countMoem++;
				} else {
					countZaeum++;
				}
			}

			if (countMoem > 0 && countZaeum > 1) {
				sb.append(b).append("\n");
			}

		} else {
			for (int i = start; i < s.length; i++) {
				tmp[index] = s[i];
				setPassword(tmp, index + 1, i + 1);
			}
		}
	}

}