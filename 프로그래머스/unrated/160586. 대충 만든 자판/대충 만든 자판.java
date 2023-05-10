import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                if (map.containsKey(key.charAt(i))) {
                    if (map.get(key.charAt(i)) > i + 1) {
                        map.put(key.charAt(i), i + 1);
                    }
                } else {
                    map.put(key.charAt(i), i + 1);
                }
            }
        }
        
        for(int i=0; i< targets.length;i++){
            int count = 0;
            for(char x : targets[i].toCharArray()){
                if(!map.containsKey(x)){
                    count = -1;
                    break;
                }
                count += map.get(x);
            }
            answer[i] = count;
        }
        return answer;
    }
}