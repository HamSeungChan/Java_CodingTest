import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char[] array = br.readLine().toCharArray();
			for (int j = array.length - 1; j >= 0; j--) {
				int pow = (int)Math.pow(10, array.length - 1 - j);
				map.put(array[j] - 'A', map.getOrDefault(array[j] - 'A', 0) + pow);
			}
		}

		List<Integer> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2) - map.get(o1);
			}
		});

		int answer = 0;
		int value = 9;

		for (Integer i : keyList) {
			answer += map.get(i) * value--;
		}

		System.out.println(answer);
	}
}