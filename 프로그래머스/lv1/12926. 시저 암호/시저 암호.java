class Solution {
    public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();
        char[] x = s.toCharArray();
        for (char c : x) {
            if (Character.isUpperCase(c)) {
                int move = c + n;
                if (move > 'Z') {
                    move = 'A' + move % ('Z' + 1);
                }
                c = (char) move;
            }
            if (Character.isLowerCase(c)) {
                int move = c + n;
                if (move > 'z') {
                    move = 'a' + move % ('z' + 1);
                }
                c = (char) move;
            }

            sb.append(c);
        }
        return sb.toString();
    }
}