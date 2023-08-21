import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		PriorityQueue<Integer> q = new PriorityQueue<>();
		int[] check = new int[n + 1];
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			check[b]++;
			list.get(a).add(b);
		}

		for (int i = 1; i <= n; i++) {
			if (check[i] == 0) {
				q.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp).append(" ");
			for (int x : list.get(tmp)) {
				check[x]--;
				if (check[x] == 0) {
					q.add(x);
				}
			}
		}
		System.out.print(sb);
	}
}