import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int a, b, c, totalLength;
	static char[] aArray, bArray;
	static int[][] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(token.nextToken());
		b = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());

		aArray = br.readLine().toCharArray();
		bArray = br.readLine().toCharArray();

		totalLength = aArray.length + bArray.length;

		dp = new int[aArray.length + 1][bArray.length + 1];

		for (int i = 0; i < aArray.length + 1; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}

		System.out.println(recursion(0, 0, 0));
	}

	public static int recursion(int aIndex, int bIndex, int index) {

		if (aIndex == aArray.length && bIndex == bArray.length) {
			return 0;
		}

		if (dp[aIndex][bIndex] != Integer.MIN_VALUE) {
			return dp[aIndex][bIndex];
		}

		int tmp = Integer.MIN_VALUE;
		// 둘 다 문자를 선택하는 경우
		if (aIndex < aArray.length && bIndex < bArray.length) {
			tmp = Math.max(tmp,
				recursion(aIndex + 1, bIndex + 1, index + 1) + (aArray[aIndex] == bArray[bIndex] ? a : c));
		}
		// 둘 중 한 명만 문자를 선택하는 경우
		if (totalLength - index > aArray.length - aIndex && bIndex < bArray.length) {
			tmp = Math.max(tmp, recursion(aIndex, bIndex + 1, index + 1) + b);
		}

		if (totalLength - index > bArray.length - bIndex && aIndex < aArray.length) {
			tmp = Math.max(tmp, recursion(aIndex + 1, bIndex, index + 1) + b);
		}

		return dp[aIndex][bIndex] = tmp;
	}
}