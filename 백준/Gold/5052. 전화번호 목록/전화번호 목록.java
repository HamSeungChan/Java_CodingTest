import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];
            for (int i = 0; i < n; i++) {
                phoneNumbers[i] = br.readLine();
            }
            Arrays.sort(phoneNumbers);

            if (isConsistent(n, phoneNumbers)) {
                sb.append("YES").append("\n");

            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isConsistent(int n, String[] phoneNumbers) {

        for (int i = 0; i < n - 1; i++) {
            if (phoneNumbers[i + 1].startsWith(phoneNumbers[i])) {
                return false;
            }
        }
        return true;
    }
}