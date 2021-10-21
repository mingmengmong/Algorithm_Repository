import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ13172 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int TC;
	static long N, M, MOD = 1_000_000_007;
	
	static long gcd(long a, long b){
		if(a % b == 0) return b;
		else return gcd(b, a%b);
	}
	
	static long mul(long a, long b){
		if(b == 1) return a % MOD;
		
		if(b % 2 == 1) return (a * mul(a, b-1)) % MOD;
		long half = mul(a, b>>>1);
		return (half * half) % MOD;
	}
	
	public static void BOJ13172(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		TC = sc.nextInt();
		long res = 0;
		while(TC-- > 0){
			N = sc.nextLong();
			M = sc.nextLong();
			
			long gcd = gcd(N,M);
			N /= gcd;
			M /= gcd;
			
			res += M * mul(N, MOD-2);
			res %= MOD;
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}