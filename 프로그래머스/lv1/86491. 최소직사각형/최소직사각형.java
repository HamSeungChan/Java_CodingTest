import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++) {

            for (int j = 0; j < sizes[i].length; j++) {
                size.add(sizes[i][j]);
            }
            big.add(Collections.max(size));
            small.add(Collections.min(size));
            
            size.clear();
        }

        return Collections.max(big)*Collections.max(small);
    }
}