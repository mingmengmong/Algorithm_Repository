import java.io.*;
import java.util.*;

public class BOJ01767 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, K, MAX=100;
	static long MOD=1_000_001;
	static long[][][] dp = new long[MAX+1][MAX+1][MAX+1];
	static{
		for(int i=0; i<=MAX; ++i)
			for(int j=0; j<=MAX; ++j)
				Arrays.fill(dp[i][j], -1);
	}
	
	static long dp(int n, int m, int k){
		if(n < 0 || m < 0 || k < 0) return 0;
		if(k == 0) return dp[n][m][k] = 1;
		if(dp[n][m][k] != -1) return dp[n][m][k];
		
		long res = dp(n-1,m,k);
		res += dp(n-1,m-1,k-1) * m;
		res += dp(n-1, m-2, k-2) * m * (m-1) / 2;
		res += dp(n-2, m-1, k-2) * m * (n-1);
		return dp[n][m][k] = res % MOD;
	}
	
	public static void BOJ01767(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		System.out.println(dp(N,M,K));
		
		br.close();
		bw.close();
		sc.close();
	}
}