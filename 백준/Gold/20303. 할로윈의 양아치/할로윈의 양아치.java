import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> graph;
    static List<GroupInfo> list;
    static boolean[] check;
    static int[] child;
    static int n, m, k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());


        child = new int[n + 1];
        check = new boolean[n + 1];
        token = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= n; i++) {
            child[i] = Integer.parseInt(token.nextToken());
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 친구들 관계 정보
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 트리(각 친구 집합의 정보를 저장하는 List)
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                list.add(bfs(i));
            }
        }


        dp = new int[list.size() + 1][k];
        for (int i = 1; i <= list.size(); i++) {
            // 그룹 정보
            GroupInfo groupInfo = list.get(i - 1);
            for (int j = 1; j < k; j++) {
                if (groupInfo.childCount <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - groupInfo.childCount] + groupInfo.candyCount);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        System.out.println(dp[list.size()][k - 1]);
    }

    public static int recursion(int index, int childCount) {

        if (dp[index][childCount] != -1) {
            return dp[index][childCount];
        }

        if (childCount >= k) {
            return -1000000000;
        }

        if (index == list.size()) {
            return 0;
        }

        GroupInfo now = list.get(index);
        int maxValue = 0;
        maxValue = Math.max(maxValue, recursion(index + 1, childCount + now.childCount) + now.candyCount);
        maxValue = Math.max(maxValue, recursion(index + 1, childCount));

        return dp[index][childCount] = maxValue;
    }


    // bfs를 통해 그룹 정보를 얻는다. 인원 수, 캔디의 갯수
    public static GroupInfo bfs(int start) {

        int childCount = 1;
        int candyCount = child[start];

        Queue<Integer> queue = new ArrayDeque<>();
        check[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            for (int next : graph.get(queue.poll())) {
                if (!check[next]) {
                    check[next] = true;
                    childCount += 1;
                    candyCount += child[next];
                    queue.add(next);
                }
            }
        }
        return new GroupInfo(childCount, candyCount);

    }
}

class GroupInfo {

    int childCount;
    int candyCount;

    public GroupInfo(int childCount, int candyCount) {
        this.childCount = childCount;
        this.candyCount = candyCount;
    }
}