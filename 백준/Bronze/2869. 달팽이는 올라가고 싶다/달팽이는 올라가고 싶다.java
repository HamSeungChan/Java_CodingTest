import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int v = Integer.parseInt(token.nextToken());

        int tmp = v - a;
        int oneDay = a - b;
        int day = (int) Math.ceil((double) tmp /oneDay);

        System.out.println(day+1);
    }
}