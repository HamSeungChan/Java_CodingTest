import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int array[];

	static int find(int n) {
		if (array[n] == n) {
			return n;
		}

		return array[n] = find(array[n]);
	}

	static boolean union(int a, int b) {
		int aFind = find(a);
		int bFind = find(b);

		if (aFind == bFind) {
			return false;
		}

		array[bFind] = aFind;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(token.nextToken());
		int e = Integer.parseInt(token.nextToken());

		array = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			array[i] = i;
		}
		PriorityQueue<Node> q = new PriorityQueue<>();
		for (int i = 0; i < e; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());

			q.offer(new Node(a, b, weight));
		}

		int answer = 0;
		int count = 0;

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (union(tmp.from, tmp.to)) {	
				answer += tmp.weight;
				count++;
			}
			
			if(count == v-1) {
				break;
			}
		}
		
		System.out.println(answer);
	}
}

class Node implements Comparable<Node> {

	int from;
	int to;
	int weight;

	public Node(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

}