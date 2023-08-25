import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, item[], graph[][];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken()); 
		m = Integer.parseInt(token.nextToken());
		int r = Integer.parseInt(token.nextToken());

		token = new StringTokenizer(br.readLine());
		item = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(token.nextToken());
		}

		graph = new int[n + 1][n + 1];

		for (int i = 0; i < r; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			graph[a][b] = weight;
			graph[b][a] = weight;
		}

		for (int i = 1; i <= n; i++) {
			daik(i);
		}

		System.out.println(answer);

	}

	public static void daik(int start) {
		int[] distance = new int[n + 1];
		boolean[] check = new boolean[n + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;
		
		for (int i = 1; i <= n; i++) {
			int index = -1;
			int min = Integer.MAX_VALUE;

			for (int j = 1; j <= n; j++) {
				if (!check[j] && min > distance[j]) {
					min = distance[j];
					index = j;
				}
			}
			
			if(index == -1) {
				break;
			}

			check[index] = true;

			for (int j = 1; j <= n; j++) {
				if (!check[j] && distance[j] > min + graph[index][j] && graph[index][j] > 0) {
					distance[j] = min + graph[index][j];
				}
			}
		}

		int count = 0;
		
		for (int i = 1; i <= n; i++) {
			if (distance[i] <= m) {
				count += item[i];
			}
		}

		answer = Math.max(count, answer);

	}
}