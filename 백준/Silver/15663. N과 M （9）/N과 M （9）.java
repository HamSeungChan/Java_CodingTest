import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] number;
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        n = Integer.valueOf(token.nextToken());
        m = Integer.valueOf(token.nextToken());
        number = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.valueOf(token.nextToken());
        }
        Arrays.sort(number);
        permutation(new int[m], 0, new int[n]);
        System.out.print(sb);
    }

    public static void permutation(int[] array, int count, int check[]) {
        if (count == m) {

            int sum = 0;
            StringBuilder tmp = new StringBuilder();
            for (int j : array) {
                tmp.append(j).append(" ");
            }
            String s = tmp.toString();
            if (!map.containsKey(s)) {
                map.put(s, 0);
                for (int x : array) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
            }
        } else {
            for (int i = 0; i < number.length; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    array[count] = number[i];
                    permutation(array, count + 1, check);
                    check[i] = 0;
                }
            }
        }
    }
}