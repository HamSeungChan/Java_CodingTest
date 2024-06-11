import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] array = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!array[i]) {
                list.add(i);
                for (int j = i * 2; j <= n; j += i) {
                    array[j] = true;
                }
            }
        }

        int lt = 0;
        int sum = 0;
        int answer = 0;
        for (int rt = 0; rt < list.size(); rt++) {
            sum += list.get(rt);
            while (sum > n) {
                sum -= list.get(lt);
                lt++;
            }
            if (sum == n) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}