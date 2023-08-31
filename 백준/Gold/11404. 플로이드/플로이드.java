import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<Node>> list = new ArrayList<>();

	static int INF = Integer.MAX_VALUE;
	static int n, m;
	static int[][] array;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		array = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		StringTokenizer token;
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			list.get(from).add(new Node(to, weight));
		}

		for (int i = 1; i <= n; i++) {
			daik(i);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static void daik(int start) {

		int[] minIndex = new int[n + 1];
		boolean[] check = new boolean[n + 1];
		Arrays.fill(minIndex, INF);
		minIndex[start] = 0;

		for (int i = 0; i < n; i++) {
			int index = -1;
			int minValue = INF;
			for (int j = 1; j <= n; j++) {
				if (minValue > minIndex[j] && !check[j]) {
					index = j;
					minValue = minIndex[j];
				}
			}

			if (index == -1) {
				break;
			}

			check[index] = true;

			for (Node n : list.get(index)) {
				if (!check[n.to] && minIndex[n.to] > minValue + n.weight) {
					minIndex[n.to] = minValue + n.weight;
				}
			}

		}

		for (int i = 1; i <= n; i++) {
			array[start][i] = minIndex[i];
			if (array[start][i] == Integer.MAX_VALUE) {
				array[start][i] = 0;
			}
		}

	}

}

class Node {
	int to;
	int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}