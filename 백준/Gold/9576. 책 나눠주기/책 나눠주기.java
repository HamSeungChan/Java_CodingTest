import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] books;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            books = new int[n + 2];
            for (int i = 1; i <= n+1; i++) {
                books[i] = i;
            }
            PriorityQueue<Info> q = new PriorityQueue<>();
            int answer = 0;
            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(token.nextToken());
                int end = Integer.parseInt(token.nextToken());
                q.offer(new Info(start, end));
            }

            while (!q.isEmpty()) {
                Info tmp = q.poll();
                int bookNumber = find(tmp.start);
                if (bookNumber > tmp.end) {
                    continue;
                }
                answer++;
                union(bookNumber, bookNumber + 1);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static int find(int value) {
        if (books[value] == value) {
            return value;
        }
        return books[value] = find(books[value]);
    }

    public static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            books[findA] = findB;
        }
    }
}

class Info implements Comparable<Info> {
    int start;
    int end;

    public Info(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Info o) {

        if (o.end == this.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}