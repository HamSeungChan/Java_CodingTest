import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        size = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(token.nextToken());
            if (parent == -1) {
                continue;
            }
            graph.get(parent).add(i);
        }

        System.out.println(recursion(0));
    }


    public static int recursion(int now) {

        List<Integer> nextList = graph.get(now);
        int[] result = new int[nextList.size()];
        int maxTime = 0;

        for (int i = 0; i < nextList.size(); i++) {
            result[i] = recursion(nextList.get(i)) + 1;
        }

        Arrays.sort(result);
        int select = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            maxTime = Math.max(maxTime, result[i] + select++);
        }

        return maxTime;
    }
}