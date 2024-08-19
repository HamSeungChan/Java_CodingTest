import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] info = new int[n][2];
        int[] check = new int[1001];
        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            info[i][0] = start;
            info[i][1] = end;

            for (int j = start; j < end; j++) {
                check[j]++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int oneCount = 0;
            for (int j = info[i][0]; j < info[i][1]; j++) {
                if (check[j] == 1) {
                    oneCount++;
                }
            }
            min = Math.min(min, oneCount);
        }
        
        int answer = 0;
        for (int i = 0; i < 1001; i++) {
            if(check[i] > 0){
                answer++;
            }
        }
        System.out.println(answer - min);
    }
}