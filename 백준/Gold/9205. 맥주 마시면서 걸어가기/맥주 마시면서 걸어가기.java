import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<int[]> list;
    static boolean[] check;
    static int sX, sY, eX, eY;

    public static void main(String[] args) throws IOException {
        StringTokenizer token;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            check = new boolean[n];

            // 시작 위치를 받는다
            token = new StringTokenizer(br.readLine(), " ");
            sX = Integer.parseInt(token.nextToken());
            sY = Integer.parseInt(token.nextToken());

            for (int i = 0; i < n; i++) {
                int[] store = new int[2];
                token = new StringTokenizer(br.readLine(), " ");
                store[0] = Integer.parseInt(token.nextToken());
                store[1] = Integer.parseInt(token.nextToken());
                list.add(store);
            }

            token = new StringTokenizer(br.readLine(), " ");
            eX = Integer.parseInt(token.nextToken());
            eY = Integer.parseInt(token.nextToken());

            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    public static String bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sX, sY});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (Math.abs(eX - tmp[0]) + Math.abs(eY - tmp[1]) <= 1000) {
                return "happy";
            }
            for(int i = 0; i < list.size(); i++){
                if(!check[i]){
                    int [] store = list.get(i);
                    if(Math.abs(store[0] - tmp[0]) + Math.abs(store[1] - tmp[1]) <= 1000){
                        check[i] = true;
                        q.offer(store);
                    }
                }
            }
        }
        return "sad";
    }

}