import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        int[] train = new int[n + 1];
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            String order = token.nextToken();
            if (order.equals("1")) {
                int trainNumber = Integer.parseInt(token.nextToken());
                train[trainNumber] = train[trainNumber] | (1 << (Integer.parseInt(token.nextToken()) - 1));
            } else if (order.equals("2")) {
                int trainNumber = Integer.parseInt(token.nextToken());
                train[trainNumber] = train[trainNumber] & ~(1 << (Integer.parseInt(token.nextToken()) - 1));
            } else if (order.equals("3")) {
                int trainNumber = Integer.parseInt(token.nextToken());
                //train[trainNumber] = (train[trainNumber] << 1) % (1 << 20);
                train[trainNumber] = train[trainNumber] << 1;
                train[trainNumber] &= (1 << 20) - 1;
            } else {
                int trainNumber = Integer.parseInt(token.nextToken());
                train[trainNumber] = train[trainNumber] >> 1;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < train.length; i++) {
            set.add(train[i]);
        }

        System.out.println(set.size());
    }
}