import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] array;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(token.nextToken());
			
			if(k == 0) {
				break;
			}
			
			array = new int[k];
			for (int i = 0; i < k; i++) {
				array[i] = Integer.parseInt(token.nextToken());
			}
			
			pick(new int[6], 0 , 0);
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	public static void pick(int[] tmp, int start, int index) {
		if (index == tmp.length) {
			
			for(int i : tmp) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			
		} else {
			for (int i = start; i < array.length; i++) {
				tmp[index] = array[i];
				pick(tmp, i + 1, index + 1);
			}
		}
	}

}