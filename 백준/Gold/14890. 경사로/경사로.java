import java.util.*;
import java.io.*;

public class Main {
    static int N,L;
    static int res = 0;
    static int[][] reqH = new int[101][101];
    static int[][] reqV = new int[101][101];

    static void move(int[][] req){
        for(int i=0;i<N;i++){
            boolean canMove = true;
            int prevRoad = 1; 

            for(int j=0;j<N-1;j++){
                int prev = req[i][j];
                int curr = req[i][j+1];
                int diff = Math.abs(prev-curr);

                if(diff == 0){
                    prevRoad++;
                }

                else if(diff == 1){
                    if(curr > prev){
                        if(prevRoad >= L){
                            prevRoad = 1;
                        }
                        else{
                            canMove = false;
                            break;
                        }
                    }

                    else{
                        for(int idx=1;idx<=L;idx++){
                            if(curr != req[i][j+idx]){
                                canMove = false;
                                break;
                            }
                        }

                        j += L-1;
                        prevRoad = 0;
                    }
                }

                else if(diff >= 2){
                    canMove = false;
                    break;
                }
            }
            if(canMove){
                res++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                reqH[i][j] = Integer.parseInt(st.nextToken());
                reqV[j][i] = reqH[i][j];
            }
        }

        move(reqH);
        move(reqV);
        System.out.println(res);
    }
}