
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        HashMap<Integer,Double> map = new HashMap<>();
        int peopleCount = 0;
        int [] countNumber = new int[N+1];
        for (int stage : stages) {
            if (stage > N) peopleCount++;
            else {
                countNumber[stage]++;
            }
        }
        for(int i = countNumber.length-1; i>=1; i--){
            if(peopleCount == 0 && countNumber[i] ==0) map.put(i,0.0);
            else{
            peopleCount+= countNumber[i];
            System.out.println((double)countNumber[i]/peopleCount);
            map.put(i, (double)countNumber[i]/peopleCount );
            }
        }

        List<Map.Entry<Integer,Double>> entryList = new ArrayList<Map.Entry<Integer,Double>>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Double> entry: entryList){
            list.add(entry.getKey());
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}