import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int d = sc.nextInt();

        int[] time = new int[5000];
        int sec = 0 ;
        for(int i=0; i<n; i++){

            for(int j=0; j<l; j++){
                time[sec++] = 1;
            }
            sec += 5;
        }
        sec = 0;
        while(true){

            if(time[sec] == 0){
                System.out.println(sec);
                break;
            }
            sec += d;
        }
    }
}