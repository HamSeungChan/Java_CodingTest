import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[] check = new int[101];
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		map = new HashMap<>();

		for (int i = 0; i < n + m; i++) {
			token = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}

		check[1] = 1;
		System.out.println(BFS(1) - 1);

	}

	public static int BFS(int start) {

		Deque<Integer> q = new ArrayDeque<>();
		q.offer(start);

		while (!q.isEmpty()) {

			int tmp = q.poll();
			if (tmp == 100) {
				return check[100];
			}

			for (int j = 1; j <= 6; j++) {
				int move = tmp + j;

				if (move > 100) {
					break;
				}

				if (map.containsKey(move) ) {
					move = map.get(move);
					if (check[move] == 0) {
						check[move] += check[tmp] + 1;
						q.offer(move);
					}
				} else {
					if (check[move] == 0) {
						check[move] += check[tmp] + 1;
						q.offer(move);
					}
				}
			}
		}
		return -1;
	}
}