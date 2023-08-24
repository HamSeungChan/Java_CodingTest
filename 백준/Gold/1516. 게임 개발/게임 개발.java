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

		int[] array = new int[n + 1];
		int[] buildTime = new int[n + 1];
		int[] answer = new int[n + 1];
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		StringTokenizer token;
		for (int i = 1; i <= n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(token.nextToken());

			buildTime[i] = time;
			while (true) {
				int priorityBuild = Integer.parseInt(token.nextToken());
				if (priorityBuild == -1) {
					break;
				}
				list.get(priorityBuild).add(i);
				array[i]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (array[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int tmp = q.poll();
			answer[tmp] += buildTime[tmp];
			for (int x : list.get(tmp)) {
				array[x]--;
				answer[x] = Math.max(answer[x], answer[tmp]);
				if (array[x] == 0) {
					q.offer(x);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(answer[i]);
		}

	}
}