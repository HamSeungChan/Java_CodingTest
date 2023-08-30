import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int answer = 0, x, n;
	static int[] array;
	static List<List<Node>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());

		array = new int[n + 1];

		list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());

			list.get(from).add(new Node(to, weight));
		}

		for (int i = 1; i <= n; i++) {
			int value = move(i, x) + move(x, i);

			answer = Math.max(answer, value);
//			System.out.println("sum = " + value);
//			System.out.println();
		}

		System.out.println(answer);

	}

	public static int move(int start, int goal) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] check = new boolean[n + 1];
		int[] v = new int[n + 1];
		Arrays.fill(v, Integer.MAX_VALUE);
		int sum = 0;

		q.add(new Node(start, 0));
		v[start] = 0;

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (!check[tmp.to]) {
				check[tmp.to] = true;
			} else {
				continue;
			}

//			System.out.println(tmp.to);

			if (tmp.to == goal) {
				sum = v[goal];
				break;
			}

			for (Node n : list.get(tmp.to)) {
				if (!check[n.to] && v[n.to] > n.weight + tmp.weight) {
					v[n.to] = n.weight + tmp.weight;
					q.add(new Node(n.to, v[n.to]));
				}
			}
		}

		return sum;
	}

}

class Node implements Comparable<Node> {
	int to;
	int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

}