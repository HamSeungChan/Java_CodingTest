import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static int find(int value) {
		if (value == parent[value]) {
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
		int n = Integer.parseInt(br.readLine());

		int[] selfDigValue = new int[n];
		parent = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			selfDigValue[i] = Integer.parseInt(br.readLine());
		}

		Queue<Node> pq = new PriorityQueue<>();

		StringTokenizer token;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int value = Integer.parseInt(token.nextToken());
				if (j < i) {
					continue;
				}
				if (i == j) {
					pq.offer(new Node(i, n, selfDigValue[i]));
					continue;
				}
				pq.offer(new Node(i, j, value));
			}
		}

		int count = 0;
		int answer = 0;

		while (true) {
			Node poll = pq.poll();
			if (union(poll.to, poll.from)) {
				answer += poll.value;
				count++;
			}
			if (count == n) {
				break;
			}
		}
		System.out.println(answer);
	}
}

class Node implements Comparable<Node> {
	int from;
	int to;
	int value;

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}

	public Node(int from, int to, int value) {
		this.from = from;
		this.to = to;
		this.value = value;
	}
}