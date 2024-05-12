import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, k, answer = 0;
	static int[][] quests;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());

		quests = new int[m][k];

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < k; j++) {
				quests[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		recursion(1, new boolean[2 * n + 1], 0);
		System.out.println(answer);
	}

	public static void recursion(int index, boolean[] pick, int pickCount) {

		if (pickCount == n) {

			int canClearCount = 0;
			for (int i = 0; i < m; i++) {
				boolean flag = false;
				for (int j = 0; j < k; j++) {
					if (!pick[quests[i][j]]) {
						flag = true;
						break;
					}
				}
				if (flag) {
					continue;
				}
				canClearCount++;
			}
			answer = Math.max(answer, canClearCount);
			return;
		}

		if (index == 2 * n + 1) {
			return;
		}

		pick[index] = true;
		recursion(index + 1, pick, pickCount + 1);

		pick[index] = false;
		recursion(index + 1, pick, pickCount);

	}

}