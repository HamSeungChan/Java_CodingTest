import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, 0);
        }
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            if(map.containsKey(s)){
                q.offer(s);
            }
        }
        System.out.println(q.size());
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}