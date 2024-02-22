import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(token.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        array = new int[map.size()];
        int index = 0;
        for (int i : map.keySet()) {
            array[index] = i;
            index++;
        }
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        int[] answer = new int[m];
        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            answer[i] = map.getOrDefault(Integer.parseInt(token.nextToken()), 0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}