import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		StringBuilder sb= new StringBuilder();
		Map<String, String> map = new HashMap<>();
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		for (int i = 0; i < n; i++) {
			tmp = br.readLine().split(" ");
			map.put(tmp[0], tmp[1]);
		}
		for (int i = 0; i < m; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
		
	}
}