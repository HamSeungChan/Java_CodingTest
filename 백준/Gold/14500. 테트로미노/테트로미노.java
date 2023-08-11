import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;
	static int[][] horizenBox = new int[2][3];
	static int[][] verticalBox = new int[3][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		graph = new int[n][m];
		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		int maxValue = 0;
		
		for (int i = 0; i < n; i++) {

			int horizenBarValue = 0;
			int verticalBarValue = 0;
			int horizenBoxValue = 0;
			int verticalBoxValue = 0;
			int squareValue = 0;

			for (int j = 0; j < m; j++) {
				if (j <= m - 4) {
					horizenBarValue = findHorizenBarValue(i, j);
				}

				if (i <= n - 4) {
					verticalBarValue = findVerticalBarValue(i, j);
				}

				if (j <= m - 3 && i <= n - 2) {
					horizenBoxValue = findHorizenBoxValue(i, j);
				}

				if (i <= n - 3 && j <= m - 2) {
					verticalBoxValue = findVericalBoxValue(i, j);
				}

				if (i <= n - 2 && j <= m - 2) {
					squareValue = findSquareValue(i, j);
				}
				
				maxValue = Math.max(maxValue, horizenBoxValue);
				maxValue = Math.max(maxValue, horizenBarValue);
				maxValue = Math.max(maxValue, verticalBarValue);
				maxValue = Math.max(maxValue, verticalBoxValue);
				maxValue = Math.max(maxValue, squareValue);
				
			}
		}
		
		System.out.println(maxValue);

	}

	public static int findSquareValue(int i, int j) {
		return graph[i][j] + graph[i][j + 1] + graph[i + 1][j] + graph[i + 1][j + 1];
	}

	public static int findHorizenBarValue(int i, int j) {
		return graph[i][j] + graph[i][j + 1] + graph[i][j + 2] + graph[i][j + 3];
	}

	public static int findVerticalBarValue(int i, int j) {
		return graph[i][j] + graph[i + 1][j] + graph[i + 2][j] + graph[i + 3][j];
	}

	public static int findHorizenBoxValue(int i, int j) {
		int sum = 0;
		int max = 0;
		for (int x = 0; x < horizenBox.length; x++) {
			for (int y = 0; y < horizenBox[0].length; y++) {
				horizenBox[x][y] = graph[i + x][j + y];
				sum += horizenBox[x][y];
			}
		}

		max = Math.max(max, sum - horizenBox[0][0] - horizenBox[0][2]);
		max = Math.max(max, sum - horizenBox[1][0] - horizenBox[1][2]);
		max = Math.max(max, sum - horizenBox[0][0] - horizenBox[1][2]);
		max = Math.max(max, sum - horizenBox[1][0] - horizenBox[0][2]);
		max = Math.max(max, sum - horizenBox[1][1] - horizenBox[1][2]);
		max = Math.max(max, sum - horizenBox[1][0] - horizenBox[1][1]);
		max = Math.max(max, sum - horizenBox[0][0] - horizenBox[0][1]);
		max = Math.max(max, sum - horizenBox[0][1] - horizenBox[0][2]);

		return max;
	}

	public static int findVericalBoxValue(int i, int j) {
		int sum = 0;
		int max = 0;
		for (int x = 0; x < verticalBox.length; x++) {
			for (int y = 0; y < verticalBox[0].length; y++) {
				verticalBox[x][y] = graph[i + x][j + y];
				sum += verticalBox[x][y];
			}
		}

		max = Math.max(max, sum - verticalBox[0][1] - verticalBox[2][0]);
		max = Math.max(max, sum - verticalBox[0][0] - verticalBox[2][1]);
		
		max = Math.max(max, sum - verticalBox[0][1] - verticalBox[2][1]);
		max = Math.max(max, sum - verticalBox[0][0] - verticalBox[2][0]);
		
		max = Math.max(max, sum - verticalBox[0][1] - verticalBox[1][1]);
		max = Math.max(max, sum - verticalBox[0][0] - verticalBox[1][0]);
		max = Math.max(max, sum - verticalBox[1][1] - verticalBox[2][1]);
		max = Math.max(max, sum - verticalBox[1][0] - verticalBox[2][0]);

		return max;
	}

}