import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        String[] array = br.readLine().split("");
        boolean[] check = new boolean[array.length];
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("P")) {

                for (int j = i - k; j <= i + k; j++) {

                    if (j < 0) {
                        continue;
                    }

                    if (j >= array.length) {
                        continue;
                    }

                    if (array[j].equals("H") && !check[j]) {
                        answer++;
                        check[j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}