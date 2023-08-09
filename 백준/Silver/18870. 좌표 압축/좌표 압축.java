import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Info> q = new PriorityQueue<>();
		String[] s = br.readLine().split(" ");
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length; i++) {
			
			q.offer(new Info(i, Integer.parseInt(s[i])));
			min = Math.min(Integer.parseInt(s[i]), min);
		}
		
		int [] answer = new int[s.length];
		
		int rating = 0;
		while(!q.isEmpty()) {
			Info tmp = q.poll();
			if(tmp.value > min) {
				rating++;
				min = tmp.value;
				answer[tmp.index] = rating;
			}else {
				answer[tmp.index] = rating;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : answer) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
}

class Info implements Comparable<Info> {
	int index;
	int value;

	public Info(int index, int value) {
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(Info o) {

		return this.value - o.value;
	}

}