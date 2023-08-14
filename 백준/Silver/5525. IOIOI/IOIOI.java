import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int size = (n + 1) + n;
		int m = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split("");
		int answer = 0;
		int length = 0;
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			if (!flag && s[i].equals("I")) {
				length++;
				flag = true;
				continue;
			}

			if (flag && !s[i - 1].equals(s[i])) {
				length++;
			}

			else if (flag && s[i - 1].equals(s[i])) {
				length = 0;
				flag = false;

				if (!flag && s[i].equals("I")) {
					length++;
					flag = true;
					continue;
				}

			}

			if (length == size) {
				answer++;
				length -= 2;
			}

		}
		System.out.println(answer);
	}
}