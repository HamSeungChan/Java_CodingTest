class Solution {
    public boolean solution(int x) {


        int i = String.valueOf(x).chars()
                .map(e -> Character.getNumericValue(e))
                .sum();

        if (x % i == 0)
            return true;

        return false;
    }
}