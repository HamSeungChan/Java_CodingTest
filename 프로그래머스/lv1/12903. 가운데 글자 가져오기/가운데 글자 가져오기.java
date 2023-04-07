class Solution {
    public String solution(String s) {
        String answer = "";
        int middle = 0;
        if(s.length()%2==0){
            middle = s.length()/2;
            return s.substring(middle-1,middle+1);
        }

        return s.substring(s.length()/2,s.length()/2+1);
    }
}