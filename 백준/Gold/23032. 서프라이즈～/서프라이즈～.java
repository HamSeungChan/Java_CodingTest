import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] prefix = new int[n + 1];
        int[] array = new int[n + 1];

        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(token.nextToken());
            prefix[i] = prefix[i - 1] + array[i];
        }


        int minDiff = Integer.MAX_VALUE;
        int answer = 0;

        for (int mid = 1; mid < n; mid++) {

            int lt = 0;
            int rt = n;

            while (lt <= mid && mid < rt) {

                int leftTeam = prefix[mid] - prefix[lt];
                int rightTeam = prefix[rt] - prefix[mid];
                
                int diff = Math.abs(rightTeam - leftTeam);
                if (minDiff > diff) {
                    minDiff = diff;
                    answer = rightTeam + leftTeam;
                }

                if (minDiff == diff && answer < rightTeam + leftTeam) {
                    answer = rightTeam + leftTeam;
                }

                if (leftTeam < rightTeam) {
                    rt--;
                } else if (leftTeam > rightTeam) {
                    lt++;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}