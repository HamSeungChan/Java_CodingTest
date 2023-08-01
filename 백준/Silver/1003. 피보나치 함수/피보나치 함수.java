import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static Map<Integer, Count> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		map = new HashMap<>();
		map.put(0, new Count(1, 0));
		map.put(1, new Count(0, 1));

		for (int t = 0; t < testCase; t++) {
			int n = Integer.valueOf(br.readLine());
			Count count = fibonacci(n);
			System.out.println(count.zeroCount + " " + count.oneCount);
		}
	}

	static Count fibonacci(int n) {
		if (n == 0) {
			return map.get(0);
		} else if (n == 1) {
			return map.get(1);
		} else {
			if (!map.containsKey(n)) {
				int zeroCount = fibonacci(n - 1).zeroCount + fibonacci(n - 2).zeroCount;
				int oneCount = fibonacci(n - 1).oneCount + fibonacci(n - 2).oneCount;
				map.put(n, new Count(zeroCount, oneCount));
				return map.get(n);
			} else {
				return map.get(n);
			}
		}
	}
}

class Count {
	int zeroCount;
	int oneCount;

	public Count(int zeroCount, int oneCount) {
		this.zeroCount = zeroCount;
		this.oneCount = oneCount;
	}
}