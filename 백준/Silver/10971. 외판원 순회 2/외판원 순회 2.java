import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, array[][];
	static int answer = Integer.MAX_VALUE;
	static int start;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		array = new int[n][n];

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			start = i;
			boolean[] b = new boolean[n];
			b[i] = true;
			DFS(0, b, i, 0);
		}

		System.out.println(answer);
	}

	public static void DFS(int count, boolean[] visit, int next, int sum) {
		if (count == n - 1) {
			if (array[next][start] > 0) {
				answer = Math.min(answer, sum + array[next][start]);
			}
		} else {
			for (int i = 0; i < n; i++) {
				if (array[next][i] > 0 && !visit[i]) {
					visit[i] = true;
					DFS(count + 1, visit, i, sum + array[next][i]);
					visit[i] = false;
				}
			}
		}
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}