import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = br.readLine();
        }

        // 문자열의 길이
        for (int i = 1; i <= 100; i++) {

            boolean flag = true;
            Set<String> set = new HashSet<>();
            for (int j = 0; j < n; j++) {

                String tmp = array[j].substring(array[j].length() - i);

                if (set.contains(tmp)) {
                    flag = false;
                    continue;
                }
                set.add(tmp);
            }
            if (flag) {
                System.out.println(i);
                break;
            }
        }
    }
}
