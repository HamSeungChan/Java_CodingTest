import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] array;

	public static int find(int n) {
		if (array[n] == n) {
			return n;
		}

		return array[n] = find(array[n]);
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		array = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			array[i] = i;
		}

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(token.nextToken());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());

			if (command == 0) {
				union(a, b);
			} else {
				if (find(a) == find(b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.print(sb);
	}
}