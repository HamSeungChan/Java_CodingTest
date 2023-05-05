import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int x : priorities) {
            q.offer(x);
        }
        Arrays.sort(priorities);
        int length = priorities.length;;
        int priorityIndex = priorities.length - 1;
        while (true) {
            int tmp = q.poll();
            if(tmp == priorities[priorityIndex]){
                priorityIndex--;
                answer++;
                if(location == 0) return answer;
                location--;
                length--;
            }
            else{
                q.offer(tmp);
                location = (location+length-1) % length;
            }
        }
    }
}