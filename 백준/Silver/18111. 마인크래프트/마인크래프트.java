import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());

        int[][] array = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.valueOf(Integer.valueOf(st.nextToken()));
                min = Math.min(min, array[i][j]);
                max = Math.max(max, array[i][j]);
            }
        }

        int answer = Integer.MAX_VALUE;
        int height = 0;

        for (int size = 0; size <= max; size++) {
            int time = 0;
            int product = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int tmp = array[i][j] - size;
                    if (tmp > 0) {
                        time += tmp * 2;
                        product += tmp;
                    }

                    if (tmp < 0) {
                        time += Math.abs(tmp);
                        product -= Math.abs(tmp);
                    }
                }
            }

            if(product < 0){
                continue;
            }

            if(time < answer){
                answer = time;
                height = size;
            }
            
            if(time == answer){
                height = Math.max(height,size);
            }
        }
        System.out.println(answer+" "+height);

    }


}