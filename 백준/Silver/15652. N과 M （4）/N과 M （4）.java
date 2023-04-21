import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int [] array = new int[m];
        new Main().DFS(array,0,1);

    }

    public void DFS(int[] array, int value, int start){
        if(value == m){
            for(int x: array){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        else{
            for(int i= start; i<=n;i++){
                array[value] = i;
                DFS(array, value+1,i);
            }
        }
    }

}
