import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {

        int sum = IntStream.range(1,10)
                .sum();

        int numbersSum = Arrays.stream(numbers)
                .sum();

        return sum - numbersSum;
    }
}