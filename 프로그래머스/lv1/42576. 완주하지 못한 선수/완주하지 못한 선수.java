import java.util.HashMap;

public class Main {
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer="";
        HashMap<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for (String completeName : completion) {
            map.put(completeName, map.get(completeName) - 1);
        }

        for(String key : map.keySet()){
            if(map.get(key)!=0){
                answer = key;
            }
        }
        return answer;
    }
}