import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static int find(int value) {
		if (parent[value] == value) {
			return value;
		}
		return parent[value] = find(parent[value]);
	}

	public static boolean union(int a, int b) {

		int findA = find(a);
		int findB = find(b);

		if (findA == findB) {
			return false;
		}
		parent[findA] = findB;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int[] array = new int[n + 1];
		token = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			if (token.nextToken().equals("M")) {
				array[i] = 1;
				continue;
			}
			array[i] = 0;
		}

		Queue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(token.nextToken());
			int from = Integer.parseInt(token.nextToken());
			int value = Integer.parseInt(token.nextToken());

			if (array[to] != array[from]) {
				pq.offer(new Node(to, from, value));
			}
		}

		int answer = 0;
		int count = 0;
		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			if (union(poll.from, poll.to)) {
				answer += poll.value;
				count++;
			}
			if (count == n - 1) {
				break;
			}
		}
		if (count != n - 1) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}

class Node implements Comparable<Node> {
	int to;
	int from;
	int value;

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}

	public Node(int to, int from, int value) {
		this.to = to;
		this.from = from;
		this.value = value;
	}
}