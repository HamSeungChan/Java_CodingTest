import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int lt = 0;
        int rt = people.length - 1;
        Arrays.sort(people);
        
        while(lt<=rt){
            if(lt == rt){
                answer++;
                break;
            }
            if(people[lt]+people[rt]>limit){
                answer++;
                rt--;
            }else {
                answer++;
                lt++;
                rt--;
            }
        }
        
        return answer;
    }
}