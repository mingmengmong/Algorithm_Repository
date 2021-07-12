package BOJ.S10000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ10253 {
	public static void BOJ10253(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; ++tc) {
			// a < b
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			while(a != 1){
				int c = b/a + 1;
				// a/b - 1/c
				// ac - b / bc
				a = a*c-b;
				b = b*c;
				int gcd = gcd(b,a);
				a /= gcd;
				b /= gcd;
			}
			System.out.println(b);
		}
		
		sc.close();
		br.close();
	}
	
	public static int gcd(int a, int b){
		return b == 0 ? a : gcd(b, a%b);
	}
}
