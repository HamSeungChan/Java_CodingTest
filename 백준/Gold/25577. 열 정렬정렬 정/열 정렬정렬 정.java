import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] array, sortArray, check;
    static int size = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        sortArray = new int[n];
        check = new int[n];

        Arrays.fill(check, -1);
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            array[i] = tmp;
            sortArray[i] = tmp;
        }
        Arrays.sort(sortArray);

        Map<Integer, Integer> map = new HashMap<>();

        int value = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sortArray[i];
            map.put(tmp, value++);
        }

        for (int i = 0; i < n; i++) {
            array[i] = map.get(array[i]);
            sortArray[i] = array[i];
        }
        Arrays.sort(sortArray);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            size = 0;
            if (check[sortArray[i]] == -1) {
                dfs(sortArray[i]);
            }
            if (size > 0) {
                answer += (size - 1);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int now) {

        int next = array[now];
        if (check[next] == -1) {
            check[next] = check[now] + 1;
            dfs(sortArray[next]);
        } else if (next != now) {
            size = check[now] - check[next] + 1;
        }
    }
}