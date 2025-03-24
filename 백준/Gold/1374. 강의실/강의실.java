import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.startTime - o2.startTime);
        Queue<Info> studying = new PriorityQueue<>((o1, o2) -> o1.endTime - o2.endTime);

        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            pq.add(new Info(b, c));
        }

        int room = 1;
        studying.add(pq.poll());

        while (!pq.isEmpty()) {
            Info poll = pq.poll();
            // 새로 시작하는 강의와 기존 진행하는 강의 시간을 비교해 끝난 강의를 제거한다.
            while (!studying.isEmpty()) {
                if (studying.peek().endTime <= poll.startTime) {
                    studying.poll();
                } else {
                    break;
                }
            }
            
            if (room <= studying.size()) {
                room++;
            }
            
            studying.add(poll);

        }
        System.out.println(room);
    }
}

class Info {
    int startTime;
    int endTime;

    public Info(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
