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

		int[] nodeInfo = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list.get(a).add(b);
			nodeInfo[b]++;
		}

		for (int i = 1; i <= n; i++) {
			if (nodeInfo[i] == 0) {
				q.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int tmp = q.poll();
				sb.append(tmp).append(" ");

				for(int j : list.get(tmp)) {
					nodeInfo[j]--;
					if (nodeInfo[j] == 0) {
						q.offer(j);
					}
				}
			}
		}
		System.out.println(sb);
	}
}