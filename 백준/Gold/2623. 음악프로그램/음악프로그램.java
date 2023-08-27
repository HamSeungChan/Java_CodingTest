import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] array = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(token.nextToken());
            int before = Integer.parseInt(token.nextToken());
            for (int j = 1; j < num; j++) {
                int singer = Integer.parseInt(token.nextToken());
                list.get(before).add(singer);
                array[singer]++;

                before = singer;
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (array[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            count++;
            sb.append(tmp).append("\n");
            for (int x : list.get(tmp)) {
                array[x]--;
                if (array[x] == 0) {
                    q.offer(x);
                }
            }
        }

        if (count != n) {
            System.out.println(0);
        } else {
            System.out.print(sb);
        }
    }
}