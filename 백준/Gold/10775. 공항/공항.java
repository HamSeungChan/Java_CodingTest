import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        parents = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            parents[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < p; i++) {
            int airPlane = Integer.parseInt(br.readLine());
            int emptyGate = find(airPlane);

            // find의 값이 0이면 더 이상 도킹이 불가능하다.
            if (emptyGate == 0) {
                break;
            }

            answer++;
            // 차선책을 등록한다. 자기 자신의 -1
            union(emptyGate, emptyGate - 1);
        }
        System.out.println(answer);
    }

    public static int find(int value) {
        if (parents[value] == value) {
            return value;
        }
        return parents[value] = find(parents[value]);
    }

    public static void union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            parents[findA] = findB;
        }
    }

}