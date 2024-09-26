import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long numberCount = 0;
        long currentNumber = 1;
        long node = 1;

        for(int i=1;i<=D;i++){
            int d = Integer.parseInt(st.nextToken());
            currentNumber = ((currentNumber-1)*i+d)%mod;
            System.out.println((numberCount+currentNumber)%mod);
            node = (node*i)%mod;
            numberCount = (numberCount+node)%mod;
        }
    }
}