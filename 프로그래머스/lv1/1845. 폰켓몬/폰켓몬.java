import java.util.HashMap;
class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int canPick = nums.length/2;
        
        if(map.size()>canPick){
            return canPick;
        }
        
        return map.size();
    }
}