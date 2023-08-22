import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<List<Integer>> list;
	static int answer = 0;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
			
		}
		


		boolean[] check = new boolean[n];
		for (int i = 0; i < n; i++) {
			check[i] = true;
			DFS(i, 0, check);
			check[i] = false;
			if (flag) {
				break;
			}
		}
		
		

		System.out.println(answer);

	}

	public static void DFS(int value, int count, boolean[] check) {

		


		if (flag) {
			return;
		}

		if (count == 4) {
			answer = 1;
			flag = true;
			return;

		} else {
			for (int x : list.get(value)) {
				if (!check[x]) {
					check[x] = true;
					DFS(x, count + 1, check);
					check[x] = false;
				}
			}
		}
	}

}