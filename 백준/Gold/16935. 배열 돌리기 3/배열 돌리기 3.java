import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int r = Integer.parseInt(token.nextToken());

		int[][] array = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		token = new StringTokenizer(br.readLine(), " ");
		for (int k = 0; k < r; k++) {
			int order = Integer.parseInt(token.nextToken());
			if (order == 1) {
				int[][] tmp = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						tmp[i][j] = array[n - 1 - i][j];
					}
				}
				array = tmp;
			} else if (order == 2) {
				int[][] tmp = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						tmp[i][j] = array[i][m - 1 - j];
					}
				}
				array = tmp;
			} else if (order == 3) {

				int x = n;
				n = m;
				m = x;

				int[][] tmp = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						tmp[i][j] = array[m - 1 - j][i];
					}
				}
				array = tmp;
			} else if (order == 4) {

				int x = n;
				n = m;
				m = x;

				int[][] tmp = new int[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						tmp[i][j] = array[j][n - 1 - i];
					}
				}
				array = tmp;

			} else if (order == 5) {
				int[][] tmp = new int[n][m];

				for (int i = 0; i < n / 2; i++) {
					for (int j = 0; j < m / 2; j++) {
						tmp[i][j] = array[i + n / 2][j];
					}
				}

				for (int i = 0; i < n / 2; i++) {
					for (int j = m / 2; j < m; j++) {
						tmp[i][j] = array[i][j - m / 2];
					}
				}

				for (int i = n / 2; i < n; i++) {
					for (int j = 0; j < m / 2; j++) {
						tmp[i][j] = array[i][j + m / 2];
					}
				}

				for (int i = n / 2; i < n; i++) {
					for (int j = m / 2; j < m; j++) {
						tmp[i][j] = array[i - n / 2][j];
					}
				}

				array = tmp;
			} else {
				int[][] tmp = new int[n][m];

				for (int i = 0; i < n / 2; i++) {
					for (int j = 0; j < m / 2; j++) {
						tmp[i][j] = array[i][j + m / 2];
					}
				}

				for (int i = 0; i < n / 2; i++) {
					for (int j = m / 2; j < m; j++) {
						tmp[i][j] = array[i + n / 2][j];
					}
				}

				for (int i = n / 2; i < n; i++) {
					for (int j = 0; j < m / 2; j++) {
						tmp[i][j] = array[i - n / 2][j];
					}
				}

				for (int i = n / 2; i < n; i++) {
					for (int j = m / 2; j < m; j++) {
						tmp[i][j] = array[i][j - m / 2];
					}
				}

				array = tmp;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}