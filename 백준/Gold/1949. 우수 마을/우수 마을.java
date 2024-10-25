import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n, answer;
    static int[] array;
    static int[][] dp;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        array = new int[n + 1];


        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dp = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }


        System.out.println(Math.max(recursion(1, 1, -1) + array[1], recursion(1, 0, -1)));
    }

    public static int recursion(int index, int pick, int parent) {

        if (dp[index][pick] != -1) {
            return dp[index][pick];
        }

        int sum = 0;

        List<Integer> nextList = graph.get(index);
        for (Integer next : nextList) {

            if (next == parent) {
                continue;
            }

            if (pick == 1) {
                sum += recursion(next, 0, index);
                continue;
            }

            sum += Math.max(recursion(next, 1, index) + array[next], recursion(next, 0, index));
        }

        return dp[index][pick] = sum;
    }
}