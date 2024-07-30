import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = br.readLine();
        }

        int answer = 0;
        int index = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            if (!tmp.equals(array[index])) {
                set.add(tmp);
                answer++;
                continue;
            }

            for (int j = index + 1; j < n; j++) {
                if (!set.contains(array[j])) {
                    index = j;
                    break;
                }
            }

        }
        System.out.println(answer);
    }
}