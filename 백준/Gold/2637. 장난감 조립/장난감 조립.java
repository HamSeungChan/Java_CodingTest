import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		StringTokenizer token;
		int[][] array = new int[n + 1][n + 1];
		int[] check = new int[n + 1];
		boolean[] init = new boolean[n + 1];
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			int k = Integer.parseInt(token.nextToken());

			init[x] = true;
			list.get(y).add(x);
			check[x]++;
			array[y][x] = k;
		}

		int[][] sum = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i][i] = 1;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (check[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int x : list.get(tmp)) {
				check[x]--;
				for (int i = 1; i <= n; i++) {
					sum[x][i] += sum[tmp][i] * array[tmp][x];
				}

				if (check[x] == 0) {
					q.offer(x);
				}
			}

//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					System.out.print(sum[i][j] + " ");
//				}
//				System.out.println();
//			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if(!init[i]) {
				sb.append(i).append(" ").append(sum[n][i]).append("\n");
			}
		}
		
		System.out.print(sb);

	}
}