import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int[] sushi = new int[d + 1];
        // 쿠폰
        sushi[c]++;
        count++;

        for (int i = 0; i < k; i++) {
            if (sushi[belt[i]] == 0) {
                count++;
            }
            sushi[belt[i]]++;
        }

        int lt = 0;
        int answer = count;
        for (int rt = k; rt < n + k - 1; rt++) {

            // 추가
            if (sushi[belt[rt % n]] == 0) {
                count++;
            }
            sushi[belt[rt % n]]++;

            // 빼기
            sushi[belt[lt]]--;
            if(sushi[belt[lt]] == 0){
                count--;
            }
            lt++;
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}