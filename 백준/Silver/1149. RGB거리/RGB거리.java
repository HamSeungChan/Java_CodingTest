import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int[][] dp;
	static int n, answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		array = new int[n][4];
		dp = new int[n][4];

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		System.out.println(recursion(0, 0));

	}

	public static int recursion(int index, int before) {

		// SUM 에 값을 누적하고 있다.
		// RETURN 하려는 값은 SUM 이다.
		// SUM이랑 ANSWER를 뺀다
		if (index == n) {
			return 0;
		}

		if (dp[index][before] != 0) {
			return dp[index][before];
		}

		int ret = 1000000000;

		for (int i = 1; i <= 3; i++) {
			if (before == i)
				continue;
			ret = Math.min(ret, recursion(index + 1, i) + array[index][i]);
		}
		return dp[index][before] = ret;
	}
}


/*
 * 탑다운 dp 짜는 법
 * 1. 백트래킹을 짠다 / VOID - > RETURN 타입으로
 * 2. 리턴하는 방식을 바꾼다
 * 3. 메모이제이션 -> 인자가 2개 임으로 DP 테이블도 2개로 설정
 * */