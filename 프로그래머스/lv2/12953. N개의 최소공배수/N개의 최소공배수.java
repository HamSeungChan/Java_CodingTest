import java.util.Arrays;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int maxValue = arr[arr.length-1];
        for(int i = maxValue; ;i+=maxValue){
            int count =0;
            for(int j =0; j<arr.length-1;j++){
                if(i%arr[j]!=0) count++;
            }
            if(count == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}