import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            check = new boolean[10000];
            answer.append(BFS(a, b)).append("\n");
        }
        System.out.print(answer);
    }

    public static StringBuilder BFS(int a, int b) {
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(a, new StringBuilder()));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Info info = q.poll();

                if (check[info.value] == true) {
                    continue;
                }

                check[info.value] = true;

                if (info.value == b) {
                    return info.sb;
                }
//                System.out.println(info.value);
//                System.out.println(info.sb);
                q.offer(D(info));
                q.offer(S(info));
                q.offer(L(info));
                q.offer(R(info));
            }
        }
        return null;
    }

    public static Info D(Info info) {
        return new Info((info.value * 2) % 10000, new StringBuilder().append(info.sb).append("D"));
    }

    public static Info S(Info info) {

        int newValue = info.value - 1;
        if (newValue == -1) {
            newValue = 9999;
        }
        return new Info(newValue, new StringBuilder().append(info.sb).append("S"));
    }

    public static Info L(Info info) {
        int one = info.value / 1000;

        return new Info((info.value % 1000) * 10 + one, new StringBuilder().append(info.sb).append("L"));
    }

    public static Info R(Info info) {
        int lastOne = info.value % 10;
        return new Info(lastOne * 1000 + info.value / 10, new StringBuilder().append(info.sb).append("R"));
    }
}

class Info {
    int value;
    StringBuilder sb;

    Info(int value, StringBuilder sb) {
        this.value = value;
        this.sb = sb;
    }
}