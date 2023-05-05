import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        int t;
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        for (int x : truck_weights) {
            if (totalWeight + x > weight) {
                while (totalWeight + x > weight) {
                    totalWeight -= bridge.poll();
                    answer++;
                    if (totalWeight + x <= weight) {
                        break;
                    }
                    bridge.offer(0);
                }
                bridge.offer(x);
                totalWeight += x;
            } else {
                
                totalWeight -= bridge.poll();
                bridge.offer(x);
                totalWeight += x;
                answer++;
            }
        }
        while (!bridge.isEmpty()) {
            t = bridge.poll();
            System.out.println(t);
            totalWeight -= t;
            answer++;
        }
        return answer;
    }
}
