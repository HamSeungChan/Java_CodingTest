import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String tmp = br.readLine();
            if (tmp.equals("0")) {
                break;
            }
            String answer = "yes";
            char[] s = tmp.toCharArray();
            for (int i = 0; i < s.length / 2; i++) {
                if (s[i] != s[s.length - 1 - i]) {
                    answer = "no";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}