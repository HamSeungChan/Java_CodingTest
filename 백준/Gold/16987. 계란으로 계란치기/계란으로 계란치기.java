import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, maxCount = 0;
    static int[] weight, durability;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        weight = new int[n];
        durability = new int[n];

        StringTokenizer token;
        for (int i = 0; i < n; i++) {

            token = new StringTokenizer(br.readLine(), " ");
            durability[i] = Integer.parseInt(token.nextToken());
            weight[i] = Integer.parseInt(token.nextToken());

        }

        recursion(0, 0);
        System.out.println(maxCount);
    }

    public static void recursion(int index, int breakCount) {

        if (index == n) {
            maxCount = Math.max(maxCount, breakCount);
            return;
        }

        if (durability[index] <= 0) {
            recursion(index + 1, breakCount);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (i == index) {
                continue;
            }

            if (durability[i] <= 0) {
                recursion(index + 1, breakCount);
                continue;
            }

            durability[index] -= weight[i];
            durability[i] -= weight[index];

            recursion(index + 1, breakCount + (durability[index] <= 0 ? 1 : 0) + (durability[i] <= 0 ? 1 : 0));

            durability[index] += weight[i];
            durability[i] += weight[index];

        }

    }
}