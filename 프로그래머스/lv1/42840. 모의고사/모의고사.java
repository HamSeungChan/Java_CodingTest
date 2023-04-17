import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2});
    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int aSum = 0;
        int bSum = 0;
        int cSum = 0;

        for (int i = 0; i < answers.length; i++) {
            if (a[i % a.length] == answers[i]) aSum++;
            if (b[i % b.length] == answers[i]) bSum++;
            if (c[i % c.length] == answers[i]) cSum++;
        }


        int max = Math.max(cSum, Math.max(aSum, bSum));
        if (max == 0) return new int[]{};
        List<Integer> list = new ArrayList<>();
        if (max == aSum) list.add(1);
        if (max == bSum) list.add(2);
        if (max == cSum) list.add(3);
        System.out.println(aSum + " " + bSum + " " + cSum);
        return list.stream().mapToInt(x -> x).toArray();
    }
}