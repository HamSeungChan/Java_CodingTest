import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
		public static void main(String [] args) {
			Scanner sc = new Scanner(System.in);
			int test_case = 10;
			for(int t =0; t< test_case;t++) {
				int testNumber = sc.nextInt();
				Queue<Integer> q =new LinkedList<>();
				for(int i=0; i< 8; i++) {
					q.offer(sc.nextInt());
				}
				int minimum = Integer.MAX_VALUE;
				int minus =1;
				while(true) {
					int tmp = q.poll() - minus;
					if(tmp <=0) {
						q.offer(0);
						break;
					}
					q.offer(tmp);
					minus++;
					if(minus == 6) {
						minus = 1;
					}
				}
				System.out.print("#"+(t+1)+" ");
				for(int i=0; i< 8;i++) {
					System.out.print(q.poll()+" ");
				}
				System.out.println();
		}
	}
}
