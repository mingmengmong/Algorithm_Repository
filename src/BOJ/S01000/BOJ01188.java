package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01188 {
	public static void BOJ01188(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int gcd = gcd(N, M);
		
		System.out.println( (M/gcd-1) * gcd );
		
		sc.close();
		br.close();
	}
	
	public static int gcd(int a, int b){
		return (b == 0 ? a : gcd(b, a%b));
	}
}