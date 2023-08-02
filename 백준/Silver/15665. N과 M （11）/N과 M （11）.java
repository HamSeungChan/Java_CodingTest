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
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        number = new int[n];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(number);
        permutaion(new int[m], 0);
        System.out.println(sb);
    }

    public static void permutaion(int[] array, int count) {
        if (count == m) {
            StringBuilder tmp = new StringBuilder();
            for (int x : array) {
                tmp.append(x).append(" ");
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
            for (int i = 0; i < n; i++) {
                array[count] = number[i];
                permutaion(array, count + 1);
            }
        }
    }

}