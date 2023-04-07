class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.toLowerCase().split(" ");

        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];

            if (str.length() == 0) {
                sb.append(" ");
                continue;
            }
            sb.append(str.substring(0, 1).toUpperCase());
            sb.append(str.substring(1, str.length()));
            sb.append(" ");
        }

        if (!" ".equals(s.substring(s.length() - 1, s.length()))) {
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }
        
        return sb.toString();
    }
}

