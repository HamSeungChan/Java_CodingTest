import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int top = 1;
        for (int i = 0; i < k; i++) {
            top = top * n;
            n--;
        }

        int bottom = 1;
        for (int i = 0; i < k; i++) {
            bottom = bottom * (k - i);
        }

        System.out.println(top / bottom);
    }
}