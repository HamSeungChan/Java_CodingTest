import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] array;
	static int[] value;
	static boolean[] pickResult;
	static int n, answer = -1, minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		pickResult = new boolean[n];
		array = new int[n][5];
		value = new int[4];

		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			value[i] = Integer.parseInt(token.nextToken());
		}

		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		subset(0, 0, 0, 0, 0, 0, new boolean[n], 0);

		StringBuilder sb = new StringBuilder();
		sb.append(answer).append("\n");

		for (int i = 0; i < pickResult.length; i++) {
			if (pickResult[i]) {
				sb.append(i + 1).append(" ");
			}
		}
		System.out.println(sb);
	}

	public static void subset(int index, int p, int f, int s, int v, int c, boolean[] pick, int pickCount) {

		if (checkMinValue(p, f, s, v) && c < minValue) {
			answer = c;
			minValue = c;
			for (int i = 0; i < n; i++) {
				pickResult[i] = pick[i];
			}
			return;
		}

		if (index == n) {
			return;
		}

		// 선택한 경우
		pick[index] = true;
		subset(index + 1, p + array[index][0], f + array[index][1], s + array[index][2], v + array[index][3],
			c + array[index][4], pick, pickCount + 1);

		// 선택하지 않은 경우
		pick[index] = false;
		subset(index + 1, p, f, s, v, c, pick, pickCount);

	}

	public static boolean checkMinValue(int p, int f, int s, int v) {
		return p >= value[0] && f >= value[1] && s >= value[2] && v >= value[3];
	}

}