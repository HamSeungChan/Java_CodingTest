import java.util.HashMap;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        int mul = 1;
        for (String s : map.keySet()) {
            mul*=(map.get(s)+1);
        }
       
        return mul-1;
    }
}