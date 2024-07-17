import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array;
    static int[] size;

    public static int find(int value) {

        if (value == array[value]) {
            return value;
        }
        return array[value] = find(array[value]);
    }

    public static void union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            size[findA] += size[findB];
            array[findB] = findA;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 부품 1 ~ 1000000
        array = new int[1000001];
        size = new int[1000001];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            size[i] = 1;
        }

        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            if (token.nextToken().equals("I")) {
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                union(a, b);
            } else {
                sb.append(size[find(Integer.parseInt(token.nextToken()))]).append("\n");
            }
        }

        System.out.print(sb);
    }
}