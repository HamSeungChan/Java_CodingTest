import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        // 사원의 수
        int n = Integer.parseInt(token.nextToken());
        // 시장이 지시한 새로운 줄의 수
        int m = Integer.parseInt(token.nextToken());
        // 데카가 화장실에 도착했을 대 앞에 서 있던 사원의 수
        int k = Integer.parseInt(token.nextToken());

        Queue<Info> pq = new PriorityQueue<>();
        int[] indexs = new int[m];
        List<List<Info>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int line = i % m;
            list.get(line).add(new Info(i, line, Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())));
        }

        for (int i = 0; i < m; i++) {
            if(!list.get(i).isEmpty()){
                pq.add(list.get(i).get(indexs[i]));
                indexs[i]++;
            }
        }

        int count = 0;
        while (!pq.isEmpty()) {
            Info poll = pq.poll();
            if (poll.index == k) {
                break;
            }

            List<Info> infos = list.get(poll.line);
            int index = indexs[poll.line];
            if (index < infos.size()) {
                pq.add(infos.get(index));
                indexs[poll.line] = index + 1;
            }
            count++;
        }
        System.out.println(count);
    }
}

class Info implements Comparable<Info> {


    int index;
    int line;
    int day;
    int high;

    public Info(int index, int line, int day, int high) {
        this.index = index;
        this.line = line;
        this.day = day;
        this.high = high;
    }


    @Override
    public int compareTo(Info o) {

        if (o.day == this.day) {
            if (o.high == this.high) {
                return this.line - o.line;
            }
            return o.high - this.high;
        }
        return o.day - this.day;
    }
}