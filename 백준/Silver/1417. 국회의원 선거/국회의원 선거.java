import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int [] array = new int[n];
        for(int i=0; i<n;i++){
            array[i] = sc.nextInt();
        }
        int answer = 0;
        while(true){

            if(array.length == 1){
                break;
            }

            int MaxIndex = 0;
            for(int i = 1; i<array.length;i++){
                if(array[MaxIndex] <= array[i]){
                    MaxIndex = i;
                }
            }
            if(MaxIndex == 0){
                break;
            }
            array[0]++;
            array[MaxIndex]--;
            answer++;
        }
        System.out.println(answer);
    }
}