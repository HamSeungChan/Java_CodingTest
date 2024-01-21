import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine()," ");

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(token.nextToken());
            minValue = Math.min(minValue, tmp);
            maxValue = Math.max(maxValue, tmp);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minValue).append(" ").append(maxValue);

        System.out.println(sb);

    }
}