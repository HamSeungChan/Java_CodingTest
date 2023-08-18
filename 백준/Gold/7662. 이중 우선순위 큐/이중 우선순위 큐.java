import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	
	static	Map<Integer, Integer> map; 
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < testCase; t++) {

			PriorityQueue<Integer> q = new PriorityQueue<>();
			PriorityQueue<Integer> reverseQ = new PriorityQueue<>(Collections.reverseOrder());
			map = new HashMap<>();
			

			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				int value = Integer.parseInt(s[1]);
				if (s[0].equals("I")) {
					q.offer(value);
					reverseQ.offer(value);
					map.put(value, map.getOrDefault(value, 0) + 1);
				} else {
					
					if(map.size() == 0) {		
						continue;
					}
						
					if(value == 1) {
						delete(reverseQ);
					}else {
						delete(q);
					}
				}
			}
			
			if(map.size() == 0) {
				sb.append("EMPTY").append("\n");
			}
			else {
				int res = delete(reverseQ);
				sb.append(res).append(" ");
				if(map.size()>0) {
					res = delete(q);
				}
				sb.append(res).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static int delete(PriorityQueue<Integer> q) {
		int res = 0;
		while(true) {
			res = q.poll();
			
			int cnt = map.getOrDefault(res, 0);
			if(cnt ==0) continue;
			
			if(cnt ==1) map.remove(res);
			else map.put(res, cnt-1);
			break;
		}
		
		return res;
	}
}