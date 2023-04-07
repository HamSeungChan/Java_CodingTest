class Solution {
    public int[] solution(long n) {
        String s = new StringBuffer(String.valueOf(n)).reverse().toString();
        System.out.println(s);
        int size = s.length();
        int[] answer = new int[size];
        for(int i=0;i<size;i++){
            System.out.println(s.charAt(i));
            answer[i] = s.charAt(i)-'0';
        }
        return answer;
    }
}