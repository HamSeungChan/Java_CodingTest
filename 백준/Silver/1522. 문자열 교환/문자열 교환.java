import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] c;
	static int aCount, bCount;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = br.readLine().toCharArray();

		aCount = 0;
		bCount = 0;
		int answer = Integer.MAX_VALUE;

		for (char tmp : c) {
			if (tmp == 'a')
				aCount++;
			else
				bCount++;
		}

		for (int i = 0; i <= aCount; i++) {
			answer = Math.min(answer, countDiff(i));
		}

		for (int i = 0; i <= bCount; i++) {
			answer = Math.min(answer, countDiff2(i));
		}

		System.out.println(answer);
	}

	public static int countDiff(int startCount) {
		int diff = 0;
		for (int i = startCount; i < startCount + bCount; i++) {
			if (c[i] != 'b') {
				diff++;
			}
		}
		return diff;
	}

	public static int countDiff2(int startCount) {
		int diff = 0;
		for (int i = startCount; i < startCount + aCount; i++) {
			if (c[i] != 'a') {
				diff++;
			}
		}
		return diff;
	}

}