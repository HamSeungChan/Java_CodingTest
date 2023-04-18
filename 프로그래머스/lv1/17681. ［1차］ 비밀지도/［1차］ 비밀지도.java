class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] map1 = new int[n][n];
        for (int i = 0; i < arr1.length; i++) {
            int index = 0;
            int secretNumber = arr1[i];
            while (secretNumber > 0) {
                map1[i][n - 1 - index++] = secretNumber % 2;
                secretNumber = secretNumber / 2;
            }
        }
        int[][] map2 = new int[n][n];
        for (int i = 0; i < arr2.length; i++) {
            int index = 0;
            int secretNumber = arr2[i];
            while (secretNumber > 0) {
                map2[i][n - 1 - index++] = secretNumber % 2;
                secretNumber = secretNumber / 2;
            }
        }
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 0 && map2[i][j] == 0){
                    sb.append(" ");
                }
                else{
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}