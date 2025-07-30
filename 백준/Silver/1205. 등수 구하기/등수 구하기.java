import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(token.nextToken());
        int s = Integer.parseInt(token.nextToken());
        int p = Integer.parseInt(token.nextToken());


        Queue<Info> pq = new PriorityQueue<>();
        if (n > 0) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                pq.add(new Info(Integer.parseInt(token.nextToken()), 1));
            }
        }


        pq.add(new Info(s, 0));

        int count = 0;
        int beforeValue = Integer.MAX_VALUE;
        int rank = 1;
        int answer = -1;

        while (!pq.isEmpty()) {

            Info poll = pq.poll();
            count++;

            if (poll.value < beforeValue) {
                rank = count;
            }

            beforeValue = poll.value;

            if (poll.value == s && poll.check == 0) {
                answer = rank;
                break;
            }

            if (count == p) {
                break;
            }

        }

        System.out.println(answer);
    }
}

class Info implements Comparable<Info> {
    int value;
    int check;

    public Info(int value, int check) {
        this.value = value;
        this.check = check;
    }

    @Override
    public int compareTo(Info o) {
        if (o.value == this.value) {
            return o.check - this.check;
        }
        return o.value - this.value;
    }
}