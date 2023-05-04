import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int chocolateSize = 1;

        //초콜릿 크기 찾기
        while (true) {
            if (chocolateSize >= k) {
                break;
            }
            chocolateSize = chocolateSize * 2;
        }
        
        // 자르기
        int cuttingCount = 0;
        int cuttingSize = chocolateSize;
        while(k>0){
            if(k<cuttingSize){
                cuttingSize = cuttingSize / 2;
                cuttingCount++;
            }
            else{
                k = k - cuttingSize;
            }
        }
        System.out.println(chocolateSize+" "+cuttingCount);
    }
}