import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (i / 100 == 0) {
				answer++;
			} else {
				int[] array = new int[3];
				int tmp = i;
				for (int j = 0; j < array.length; j++) {
					array[j] = tmp % 10;
					tmp = tmp / 10;
				}
				if (array[0] - array[1] == array[1] - array[2]) {
					answer++;
				}
			}
			if(i==1000) answer--;
		}
		System.out.println(answer);
	}
}