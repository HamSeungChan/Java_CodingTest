import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int phoneSize = 16;
        int phoneA = sc.nextInt();
        int phoneB = sc.nextInt();

        int[] phone = new int[phoneSize];
        for (int i = 0; i < phoneSize; i = i + 2) {
            phone[i] = phoneB % 10;
            phoneB = phoneB / 10;
            phone[i + 1] = phoneA % 10;
            phoneA = phoneA / 10;
        }

        while (phoneSize > 2) {
            phoneSize--;
            int[] sumPhone = new int[phoneSize];
            for(int i =0; i< sumPhone.length; i++){
                sumPhone[i] = (phone[i] + phone[i+1]) % 10;
            }
            phone = sumPhone;
        }

        System.out.println(phone[1]+""+phone[0]);
    }
}