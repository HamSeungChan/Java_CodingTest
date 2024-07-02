
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n][2];
        check = new boolean[n];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i][0] = Integer.parseInt(token.nextToken());
            array[i][1] = i;
        }
        Arrays.sort(array, Comparator.comparingInt(o -> o[0]));

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                answer += dfs(i);
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int now) {

        check[now] = true;
        int size = 0;
        if (!check[array[now][1]]) {
            size = dfs(array[now][1]) + 1;
        }

        return size;
    }

}