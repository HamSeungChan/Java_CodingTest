import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		int[] check = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list.get(a).add(b);
			check[b]++;
		}

		for (int i = 1; i <= n; i++) {
			if (check[i] == 0) {
				q.add(i);
			}
		}

		int[] sequence = new int[n + 1];
		int count = 1;
		while (!q.isEmpty()) {

			int size = q.size();
			for (int s = 0; s < size; s++) {
				int tmp = q.poll();
				sequence[tmp] = count;
				for (int x : list.get(tmp)) {
					check[x]--;
					if (check[x] == 0) {
						q.add(x);
					}
				}
			}
			count++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(sequence[i]).append(" ");
		}

		System.out.println(sb);

	}
}