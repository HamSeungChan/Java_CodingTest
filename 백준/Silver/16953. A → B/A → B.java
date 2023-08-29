import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int goal, answer = -1;
	static Set<Long> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(token.nextToken());
		goal = Integer.parseInt(token.nextToken());
		check(start, 1);
		System.out.println(answer);
	}

	public static void check(long i, int depth) {

		if (i == goal) {
			answer = depth;
		}

		if (i > goal) {
			return;
		}

		if (!set.contains(i)) {
			set.add(i);
			check(i * 2, depth + 1);
			check(i * 10 + 1, depth + 1);
		}

	}
}