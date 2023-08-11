import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger bigN = new BigInteger(st.nextToken());
		BigInteger bigr = new BigInteger(st.nextToken());
		
		
		BigInteger answer = new BigInteger("0");
		if(bigN.equals("1")) {
			answer = answer.add(new BigInteger("2"));
		}
		
		
		
		else{
			if(bigr.equals("1")) {
				System.out.println(bigN.add(new BigInteger("1")));
			}else {
				BigInteger mul = new BigInteger("2").multiply(bigr.subtract(new BigInteger("1")));
				System.out.println(bigN.add(new BigInteger("1")).add(mul));
				
			}
		}
		
	}
}