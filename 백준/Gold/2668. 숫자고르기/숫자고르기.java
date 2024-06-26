import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static int n;
    static boolean[] answer;
    static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        answer = new boolean[n + 1];
        array = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            dfs(array[i], i, new boolean[n + 1]);
        }

        int size = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (answer[i]) {
                size++;
                sb.append(i).append("\n");
            }
        }
        System.out.println(size);
        System.out.print(sb);
    }

    public static void dfs(int next, int target, boolean[] check) {

        if (next == target) {
            answer[target] = true;
            return;
        }

        if (!check[array[next]]) {
            check[array[next]] = true;
            dfs(array[next], target, check);
            check[array[next]] = false;
        }
    }
}