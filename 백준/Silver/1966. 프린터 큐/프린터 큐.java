import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int index = Integer.parseInt(s[1]);

            PriorityQueue<Paper> pq = new PriorityQueue<>();
            Queue<Paper> q = new LinkedList<>();
            s = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                Paper paper = new Paper(i, Integer.parseInt(s[i]));
                pq.offer(paper);
                q.offer(paper);
            }
            int printCount = 0;
            while (true) {

                Paper paper = q.poll();
                if (paper.priority == pq.peek().priority) {
                    printCount++;
                    pq.poll();
                    if (paper.startIndex == index) {
                        sb.append(printCount).append("\n");
                        break;
                    }
                }
                q.offer(paper);
            }
        }
        System.out.print(sb);
    }
}

class Paper implements Comparable<Paper> {
    int startIndex;
    int priority;

    public Paper(int startIndex, int priority) {
        this.startIndex = startIndex;
        this.priority = priority;
    }

    @Override
    public int compareTo(Paper o) {
        return (this.priority - o.priority) * -1;
    }
}