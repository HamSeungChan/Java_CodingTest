import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Solution {
      public String solution(String s) {
        return Stream.of(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }
}