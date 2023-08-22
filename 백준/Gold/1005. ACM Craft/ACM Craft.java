import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < testCase; t++) {
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(token.nextToken());
			int k = Integer.parseInt(token.nextToken());

			int[] time = new int[n + 1];
			int[] check = new int[n + 1];

			token = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				time[i] = Integer.parseInt(token.nextToken());
			}

			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < k; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				list.get(a).add(b);
				check[b]++;
			}

			Queue<Integer> q = new LinkedList<>();
			int[] answer = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				if (check[i] == 0) {
					q.add(i);
					answer[i] = time[i];
				}
			}

			while (!q.isEmpty()) {
				int tmp = q.poll();
				for (int i : list.get(tmp)) {
					answer[i] = Math.max(answer[i], answer[tmp] + time[i]);
					check[i]--;
					if (check[i] == 0) {
						q.add(i);
					}
				}
			}
			sb.append(answer[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.print(sb);
	}
}