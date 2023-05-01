import java.util.Arrays;


class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;

        Arrays.sort(citations);
        for (int i = 1; i <= 1000; i++) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] - i >= 0) count++;
                if (count >= i) {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}