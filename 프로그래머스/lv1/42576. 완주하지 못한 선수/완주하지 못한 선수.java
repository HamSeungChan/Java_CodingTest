import java.util.HashMap;
import java.util.Iterator;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for (String completeName : completion) {
            map.put(completeName, map.get(completeName) - 1);
            if (map.get(completeName) == 0) {
                map.remove(completeName);
            }
        }

        Iterator<String> keys = map.keySet().iterator();
        return keys.next();
    }
}