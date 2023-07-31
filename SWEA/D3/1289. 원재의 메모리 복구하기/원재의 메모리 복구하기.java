import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			String[] strings = sc.next().split("");
			String[] tmp = new String[strings.length];
			for(int i=0; i<tmp.length;i++) {
				tmp[i] = "0";
			}
			int nextIndex = 0;
			int cnt = 0;
			for (int i = 0; i < strings.length; i++) {
				if (!strings[i].equals(tmp[i])) {
					nextIndex = i + 1;
					cnt++;
					for (int j = nextIndex; j < strings.length; j++) {
						tmp[j] = strings[i];
					}
				}
			}

			System.out.println("#" + t + " " + cnt);
		}

	}
}