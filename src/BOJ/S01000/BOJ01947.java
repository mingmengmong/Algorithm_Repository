import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ01947 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX=1_000_000;
	static long MOD=1_000_000_000;
	static long[] dp = new long[MAX+1];
	
	public static void BOJ01947(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		dp[2] = 1;
		for(int i=3; i<=N; ++i){
			dp[i] = ((i-1) * ((dp[i-1] + dp[i-2]) % MOD)) % MOD;
		}
		
		System.out.println(dp[N]);
		
		br.close();
		bw.close();
		sc.close();
	}
}