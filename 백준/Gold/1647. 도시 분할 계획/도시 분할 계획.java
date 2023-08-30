import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		array = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}
		PriorityQueue<Node> q = new PriorityQueue<>();

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			q.offer(new Node(from, to, weight));
		}

		int sum = 0;
		int maxValue = 0;
		int count = 0;
		
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if(union(tmp.to,tmp.from)) {
				sum += tmp.weigth;
				count++;
				maxValue = Math.max(maxValue, tmp.weigth);
			}
			
			if(count == n-1) {
				break;
			}
		}
		
		System.out.println(sum - maxValue);

	}

	public static int find(int x) {
		if (array[x] == x) {
			return x;
		}
		return array[x] = find(array[x]);
	}

	public static boolean union(int a, int b) {
		int aFind = find(a);
		int bFind = find(b);

		if (aFind == bFind) {
			return false;
		}

		array[bFind] = aFind;
		return true;
	}

}

class Node implements Comparable<Node> {
	int from;
	int to;
	int weigth;

	public Node(int from, int to, int weigth) {

		this.from = from;
		this.to = to;
		this.weigth = weigth;
	}

	@Override
	public int compareTo(Node o) {
		return this.weigth - o.weigth;
	}
}