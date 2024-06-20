import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCase; t++) {

            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(token.nextToken());
                set.add(array[i]);
            }
            Arrays.sort(array);
            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int value = array[j] - array[i];
                    if (set.contains(array[j] + value)) {
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}