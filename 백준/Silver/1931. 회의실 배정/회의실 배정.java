import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Time> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            list.add(new Time(startTime, endTime));
        }
        Collections.sort(list);
        int lastTime = 0;
        int answer = 0;
        for (Time t : list) {
           
            if (t.startTime >= lastTime) {
                answer++;
                lastTime = t.endTime;
            }
        }
        System.out.println(answer);
    }
}

class Time implements Comparable<Time> {

    int startTime;
    int endTime;

    Time(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Time o) {
        if (this.endTime == o.endTime) {
            return this.startTime - o.startTime;
        }
        return this.endTime - o.endTime;
    }
}

