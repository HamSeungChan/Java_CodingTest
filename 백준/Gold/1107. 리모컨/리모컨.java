import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(sc.nextInt());
        }
        int answer = Math.abs(100-n);
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            boolean check = true;
            for (int j = 0; j < s.length(); j++) {
                if(list.contains(s.charAt(j)-'0')){
                    check = false;
                    break;
                }
            }
            if(check == false){
                continue;
            }

            answer = Math.min(answer,Math.abs(i-n)+s.length());
        }
        System.out.println(answer);
    }
}