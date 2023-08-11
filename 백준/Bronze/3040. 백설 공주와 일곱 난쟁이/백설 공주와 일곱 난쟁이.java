import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] array = new int[9];
		int totalSum = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(br.readLine());
			totalSum += array[i];
		}
		int[] tmp = new int[9];
		for (int i = 0; i < 2; i++) {
			tmp[tmp.length - 1 - i] = 1;
		}
		
		do {
			
			int npResultSum = 0;
			for(int i = 0; i< tmp.length; i++) {
				if(tmp[i] == 1) {
					npResultSum += array[i];
				}
			}
			
			if(totalSum - npResultSum == 100 ) {
				for(int i = 0; i< tmp.length; i++) {
					if(tmp[i] != 1) {
						sb.append(array[i]).append("\n");
					}
				}
				
				break;
			}
			
			
		}while(np(tmp));
		
		System.out.println(sb);
	}

	public static boolean np(int[] tmp) {

		int n = tmp.length;
		int i = n - 1;
		while (i > 0 && tmp[i - 1] >= tmp[i]) {
			i--;
		}

		if (i == 0) {
			return false;
		}

		int j = n - 1;
		while (tmp[i - 1] >= tmp[j]) {
			j--;
		}

		swap(tmp, i - 1, j);
		
		int k = n - 1;
		while(i < k) {
			swap(tmp,i++,k--);
		}

		return true;
	}

	public static void swap(int[] array, int a, int b) {

		array[a] ^= array[b];
		array[b] ^= array[a];
		array[a] ^= array[b];

	}

}