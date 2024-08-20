import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] array = br.readLine().toCharArray();
        int[] check = new int[26];


        for (int i = 0; i < n / 2; i++) {
            check[array[i] - 'a']++;
        }

        for (int i = n - 1; i > n - 1 - n / 2; i--) {
            check[array[i] - 'a']++;
        }

        boolean flag = false;
        for (int i : check) {
            if (i % 2 == 1) {
                flag = true;
                break;
            }
        }
        System.out.println(!flag ? "Yes" : "No");
    }
}