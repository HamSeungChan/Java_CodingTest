import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        int startPoint = Integer.parseInt(br.readLine()) - 1;
        List<List<Info>> list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]) - 1;
            int b = Integer.parseInt(s[1]) - 1;
            int weight = Integer.parseInt(s[2]);
            list.get(a).add(new Info(b, weight));
        }

        int[] answer = new int[v];
        boolean[] check = new boolean[v];
        Arrays.fill(answer, Integer.MAX_VALUE);

        answer[startPoint] = 0;


        for (int i = 0; i < v; i++) {
            int index = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < v; j++) {
                if (answer[j] < minValue && !check[j]) {
                    index = j;
                    minValue = answer[j];
                }
            }
            if (index == -1) {
                break;
            }

            check[index] = true;


            List<Info> tmp = list.get(index);
            for (Info x : tmp) {
                if (!check[x.to] && answer[x.to] > x.weight + minValue) {
                    answer[x.to] = x.weight + minValue;
                }
            }


        }

        StringBuilder sb = new StringBuilder();

        for (int x : answer) {
            if (x == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }

            sb.append(x).append("\n");

        }

        System.out.print(sb);
    }
}

class Info {
    int to;
    int weight;

    public Info(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}