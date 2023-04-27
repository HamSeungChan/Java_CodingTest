import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       List<Integer> answerList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int progress : progresses) {
            q.offer(progress);
        }
        int point = 0;
        while(!q.isEmpty()){
            if(q.peek()>=100){
                int answer = 0;
                while(q.peek()>=100){
                    q.poll();
                    answer++;
                    point++;
                    if(q.isEmpty()) break;
                }
                answerList.add(answer);
//                int answer =0;
//                int qSize = q.size();
//                for(int i=0; i<qSize;i++){
//                    int tmp = q.poll();
//                    if(tmp >=100){
//                        System.out.println(tmp);
//                        answer++;
//                        point++;
//                    }
//                    else{
//                        q.offer(tmp);
//                        q.
//                        break;
//                    }
//                }
//                answerList.add(answer);
            }
            else{
                for(int i = point ; i<speeds.length;i++){
                    int tmp = q.poll();
                    q.add(tmp+speeds[i]);
                }
            }
        }
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}