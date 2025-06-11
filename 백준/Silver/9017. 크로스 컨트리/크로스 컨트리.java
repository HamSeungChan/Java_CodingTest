import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < t; testCase++) {

            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            int[] value = new int[n];
            token = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < n; i++) {
                int tmp = Integer.parseInt(token.nextToken());
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                value[i] = tmp;
            }

            boolean[] check = new boolean[map.size() + 1];
            int[] score = new int[map.size() + 1];
            int[] fiveScore = new int[map.size() + 1];
            int[] count = new int[map.size() + 1];

            Set<Integer> set = new HashSet<>();
            for (Integer key : map.keySet()) {
                if (map.get(key) == 6) {
                    check[key] = true;
                }
            }


            int s = 1;

            for (int i = 0; i < value.length; i++) {

                int tmp = value[i];
                if (check[tmp]) {

                    count[tmp]++;

                    if (count[tmp] <= 4) {
                        score[tmp] += s;
                    }

                    if (count[tmp] == 5) {
                        fiveScore[tmp] = s;
                    }
                    s++;
                }
            }

            int minValue = Integer.MAX_VALUE;
            int fiveValue = Integer.MAX_VALUE;
            int answer = 0;

            for (int i = 0; i < score.length; i++) {
                if (count[i] == 6) {
                    if (minValue > score[i]) {
                        fiveValue = fiveScore[i];
                        answer = i;
                        minValue = score[i];
                    } else if (minValue == score[i]) {
                        if (fiveValue > fiveScore[i]) {
                            fiveValue = fiveScore[i];
                            answer = i;
                            minValue = score[i];
                        }
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}