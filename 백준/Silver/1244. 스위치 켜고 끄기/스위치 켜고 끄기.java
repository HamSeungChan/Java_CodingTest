import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int swCount = Integer.valueOf(br.readLine());
		boolean[] sw = new boolean[swCount + 1];
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= swCount; i++) {
			if (Integer.valueOf(token.nextToken()) == 1) {
				sw[i] = true;
			} else {
				sw[i] = false;
			}

		}
		int people = Integer.valueOf(br.readLine());
		for (int i = 0; i < people; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int mw = Integer.valueOf(token.nextToken());
			int number = Integer.valueOf(token.nextToken());

			if (mw == 1) {
				for (int j = number; j < sw.length; j += number) {
					sw[j] = !sw[j];
				}
			} else {

				int left = number;
				int right = number;

				while (true) {

					if (left - 1 < 1 || right + 1 > swCount || sw[left - 1] != sw[right + 1]) {
						break;
					}
					left--;
					right++;
				}
				for (int j = left; j <= right; j++) {
					sw[j] = !sw[j];
				}
			}

		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i< sw.length; i++) {
			if(sw[i] == true) {
				sb.append("1").append(" ");
			}
			else {
				sb.append("0").append(" ");
			}
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb);

	}
}