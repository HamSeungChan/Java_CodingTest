import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] people;

	static int find(int n) {
		if (people[n] == n) {
			return n;
		}

		return people[n] = find(people[n]);
	}

	static boolean union(int a, int b) {
		int aFind = find(a);
		int bFind = find(b);

		if (aFind == bFind) {
			return false;
		}

		people[bFind] = aFind;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());

		people = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			people[i] = i;
		}

		token = new StringTokenizer(br.readLine(), " ");
		int trueKnowPeople = Integer.parseInt(token.nextToken());
		for (int i = 0; i < trueKnowPeople; i++) {
			union(0, Integer.parseInt(token.nextToken()));
		}

		int answer = 0;
		int[] start = new int[m];

		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int peopleCount = Integer.parseInt(token.nextToken());
			int[] array = new int[peopleCount];
			for (int j = 0; j < peopleCount; j++) {
				array[j] = Integer.parseInt(token.nextToken());
				union(array[0], array[j]);
			}
			start[i] = array[0];
		}

		for (int i : start) {
			if (find(0) != find(i)) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}