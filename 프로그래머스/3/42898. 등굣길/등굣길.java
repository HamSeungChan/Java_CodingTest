import java.util.*;

class Solution {
    
    static int [] MOVE_X = {1, 0};
    static int [] MOVE_Y = {0, 1};
    static int [][] map;
    static int [][] dp;
    static int nx, my;
    
    public int solution(int m, int n, int[][] puddles) {
        
        nx = n;
        my = m;
        
        map = new int[n][m];
        dp = new int[n][m];
        
        for(int i = 0; i <n; i++){
            Arrays.fill(dp[i] , -1);
        }
        
        for(int i = 0; i < puddles.length; i++){
            int x = puddles[i][1] - 1;
            int y = puddles[i][0] - 1;
            
            map[x][y] = -1;
        }

        return recursion(0,0);
    }
    
    public static int recursion(int x, int y){
        
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        
        if(x == nx - 1 && y == my - 1){
            return 1;
        }
        
        int count = 0;
        
        for(int i = 0; i < 2; i++){
            int moveX = x + MOVE_X[i];
            int moveY = y + MOVE_Y[i];
            
            if(inRange(moveX, moveY) && map[moveX][moveY] != -1){
                count = (count + recursion(moveX, moveY)) % 1000000007;
            }
        }
        return dp[x][y] = count;
    }
    
    public static boolean inRange(int x, int y){
        return 0<= x && x < nx && 0 <= y && y < my;
    }
}