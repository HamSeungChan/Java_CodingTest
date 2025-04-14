import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++){
            pq.add(works[i]);
        }
        
        for(int i = 0; i < n; i++){
            int max = pq.poll();
            if(max == 0){
                return 0;
            }
            pq.add(max - 1);
        }
        
        while(!pq.isEmpty()){
            int now = pq.poll();
            answer += now * now;
        }
        
        return answer;
    }
}