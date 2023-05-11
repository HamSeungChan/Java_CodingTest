import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String [] s = new String[numbers.length];
        for(int i=0; i<numbers.length;i++){
            s[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(s[0].equals("0")) return "0";

        StringBuilder sb= new StringBuilder();
        for(String ss : s){
            sb.append(ss);
        }
        return sb.toString();
    }
}