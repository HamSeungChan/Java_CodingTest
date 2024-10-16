import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {

            // 슬아임의 수
            long n = Integer.parseInt(br.readLine());
            long totalExp = (1 + n) * (n / 2) + (n % 2 == 1 ? (1 + n) / 2 : 0);

            long lt = 1;
            long rt = 1000000000;
            long answer = 0;
            while (lt <= rt) {
                long mid = (lt + rt) / 2;
                long needExp = needExp(mid);
                if (totalExp >= needExp) {
                    answer = mid;
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static long needExp(long level) {
        long lastExp = (level - 1) * 2;
        return lastExp * (level / 2) + (level % 2 == 1 ? (lastExp / 2) : 0);
    }
}