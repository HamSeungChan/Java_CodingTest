import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Time> list = new ArrayList<>();
        StringTokenizer token;
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            list.add(new Time(start, end));
        }
        Collections.sort(list);

        int answer = 0;
        int now = 0;
        for (Time time : list) {
            if (time.start >= now) {
                answer++;
                now = time.end;
            }
        }
        System.out.println(answer);
    }
}

class Time implements Comparable<Time> {


    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {

        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}