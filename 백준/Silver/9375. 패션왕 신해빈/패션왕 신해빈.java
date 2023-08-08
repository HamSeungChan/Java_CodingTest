import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			Map<String,Integer> map = new HashMap<>();
			
			int n = Integer.parseInt(br.readLine());
			for(int i =0; i< n; i++) {
				String [] s = br.readLine().split(" ");
				map.put(s[1], map.getOrDefault(s[1], 0)+1);
			}
			int answer = 1;
			for(int i : map.values()) {
				answer *= (i+1);
			}
			System.out.println(answer - 1);
			
		}
	}
}