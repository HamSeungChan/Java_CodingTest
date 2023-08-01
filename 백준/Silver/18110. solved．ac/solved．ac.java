import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new PriorityQueue<>();
        int n  = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            q.offer(Integer.valueOf(br.readLine()));
        }
        int delete = (int) Math.round(n * 0.3 / 2);
        
        for (int i = 0; i < delete; i++) {
            q.poll();
        }

        int sum = 0;
        for (int i = delete; i < n - delete; i++) {
            sum += q.poll();
        }
        System.out.println(Math.round((double)sum / (n - delete * 2)));
    }
}