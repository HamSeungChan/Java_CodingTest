import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] people = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(s[0]);
            people[i][1] = Integer.parseInt(s[1]);
        }


        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank++;
                }
            }
            System.out.print(rank+" ");
        }
    }
}