import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] array;
    static boolean[] check;
    static int minValue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());    // 학생 수
        int m = Integer.parseInt(token.nextToken());    // 친구관계 수
        int k = Integer.parseInt(token.nextToken());    // 가지고 있는 돈

        array = new int[n + 1];  // 친구비를 저장하는 배열
        check = new boolean[n + 1]; // dfs 방문 여부를 확인하는 배열
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        // 친구들간의 연관관계
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                minValue = array[i];
                dfs(i);
                sum += minValue;
            }
        }
        System.out.println(sum <= k ? sum : "Oh no");
    }

    public static void dfs(int now) {

        check[now] = true;
        minValue = Math.min(minValue, array[now]);

        List<Integer> list = graph.get(now);
        for (Integer next : list) {
            if (!check[next]) {
                dfs(next);
            }
        }
    }
}