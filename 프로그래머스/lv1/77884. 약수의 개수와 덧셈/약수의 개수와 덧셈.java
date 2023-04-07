import java.util.stream.IntStream;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int number = left; number <= right; number++) {
            int finalNumber = number;
            long count = IntStream.range(1,finalNumber+1)
                    .filter(i -> finalNumber % i ==0)
                    .count();
            if(count % 2 ==0 ) answer +=number;
            else answer -= number;
        }

        return answer;
    }
}
