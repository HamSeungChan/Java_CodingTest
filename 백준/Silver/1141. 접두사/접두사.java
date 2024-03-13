import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		String[] array = new String[n];

		for (int i = 0; i < n; i++) {
			array[i] = br.readLine();
		}

		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		List<List<String>> list = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			list.add(new ArrayList<>());
		}

		for (String s : array) {
			boolean b = false;
			char c = s.charAt(0);
			List<String> strings = list.get(c - 'a');
			for (String string : strings) {
				if (string.startsWith(s)) {
					b = true;
					break;
				}
			}
			if (b) {
				continue;
			}
			strings.add(s);
		}

		int answer = 0;
		for (List<String> strings : list) {
			answer += strings.size();
		}
		System.out.println(answer);
	}
}