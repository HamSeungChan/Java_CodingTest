import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static int find(int value) {

        if (value == parent[value]) {
            return value;
        }

        return parent[value] = find(parent[value]);
    }

    public static void union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {

            if (findA <= findB) {
                parent[findA] = findB;
            } else {
                parent[findB] = findA;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int[] colors = new int[n + 1];

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }


        int q = Integer.parseInt(token.nextToken());

        for (int i = 0; i < q; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int color = Integer.parseInt(token.nextToken());

            while (start <= end) {

                // 처음 색칠을 한 경우
                if (colors[start] == 0) {
                    colors[start] = color;

                    // start 의 위치에 끝은 end가 확실
                    union(start, end);
                    start++;
                }
                // 이미 색칠된 경우
                // 색칠된 정보의 끝 index 를 찾는다.
                else {
                    int finishIndex = find(start);
                    union(finishIndex, end);
                    start = finishIndex + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(colors[i]).append(" ");
        }
        System.out.print(sb);
    }
}