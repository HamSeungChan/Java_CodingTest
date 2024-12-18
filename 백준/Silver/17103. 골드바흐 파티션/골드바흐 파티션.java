import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[1000001];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 1000000; i++) {
            if (!check[i]) {
                list.add(i);
                for (int j = i; j < 1000001; j = j + i) {
                    check[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int findValue = Integer.parseInt(br.readLine());
            int lt = 0;
            int rt = list.size() - 1;

            int answer = 0;
            while (lt <= rt) {

                int sum = list.get(lt) + list.get(rt);
                if (sum > findValue) {
                    rt--;
                } else if (sum < findValue) {
                    lt++;
                } else {
                    answer++;
                    lt++;
                    rt--;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}