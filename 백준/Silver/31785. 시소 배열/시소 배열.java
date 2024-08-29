import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        int[] array = new int[q + 1];

        int lt = 0;
        int rt = 0;

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int question = Integer.parseInt(token.nextToken());


            // 삽입 명령어
            if (question == 1) {
                rt++;
                array[rt] = array[rt - 1] + Integer.parseInt(token.nextToken());
            }

            // 비교 명령어
            else {
                int mid = (rt + lt) / 2;
                int leftSum = array[mid] - array[lt];
                int rightSum = array[rt] - array[mid];

                if (leftSum <= rightSum) {
                    sb.append(leftSum).append("\n");
                    lt = mid;
                } else {
                    sb.append(rightSum).append("\n");
                    rt = mid;
                }
            }
        }

        for (int i = lt + 1; i <= rt; i++) {
            sb.append(array[i] - array[i - 1]).append(" ");
        }

        System.out.println(sb);
    }
}