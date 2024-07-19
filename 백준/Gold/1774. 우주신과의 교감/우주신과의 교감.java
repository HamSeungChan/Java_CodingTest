import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static int find(int value) {
        if (parent[value] == value) {
            return value;
        }
        return parent[value] = find(parent[value]);
    }

    public static boolean union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        // 다르다면
        if (findA != findB) {
            parent[findB] = findA;
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int[][] array = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                array[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        Queue<Point> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {

                int value1 = array[i][0] - array[j][0];
                int value2 = array[i][1] - array[j][1];


                pq.add(new Point(i, j, Math.sqrt(Math.pow(value1, 2) + Math.pow(value2, 2))));
            }
        }


        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            union(a, b);
        }


        int count = m;
        double answer = 0;
        while (!pq.isEmpty()) {
            Point tmp = pq.poll();
            if (union(tmp.to, tmp.from)) {
                count += 1;
                answer += tmp.value;

            }
        }
        System.out.println(String.format("%.2f", answer));
    }
}

class Point implements Comparable<Point> {
    int to;
    int from;
    double value;

    public Point(int to, int from, double value) {
        this.to = to;
        this.from = from;
        this.value = value;
    }

    @Override
    public int compareTo(Point o) {
        return Double.compare(this.value, o.value);
    }
}