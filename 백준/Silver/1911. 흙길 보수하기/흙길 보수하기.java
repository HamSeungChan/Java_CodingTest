import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int boxSize = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int answer = 0;
        int range = 0;
        for(int i =0; i<n;i++){
            if(arr[i][0]> range){
                range = arr[i][0];
            }
            if(arr[i][1]>=range){
                while(arr[i][1]>range){
                    range += boxSize;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}