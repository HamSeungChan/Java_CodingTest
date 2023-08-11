import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int l = Integer.parseInt(s[1]);

		int[] array = new int[n];
		s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(array);
		
		for(int i : array) {
			if(i <= l) {
				l++;
			}
			else {
				break;
			}
		}
		
		System.out.println(l);
	}
}