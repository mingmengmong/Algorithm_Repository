import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ01648 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N,M, MAX=14, MOD=9_901;
	static int[][] dp = new int[MAX*MAX+1][1<<MAX];
	
	
	public static void BOJ01648(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		if(((N*M) & 1) == 1){
			System.out.println(0);
			return;
		}
		
		dp[0][0] = 1;
		int SIZE = 1 << M;
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j){
				int jIdx = 1 << j;
				int idx = i*M+j;
				for(int k=0; k<SIZE; ++k){
					if((jIdx & k) > 0){
						dp[idx+1][k-jIdx] += dp[idx][k];
						dp[idx+1][k-jIdx] %= MOD;
					}else{
						dp[idx+1][k+jIdx] += dp[idx][k];
						dp[idx+1][k+jIdx] %= MOD;
						
						int jIdxR = 1 << (j+1);
						if(j < M-1 && (jIdxR & k) == 0){
							dp[idx+1][k+jIdxR] += dp[idx][k];
							dp[idx+1][k+jIdxR] %= MOD;
						}
					}
				}
			}
		}
		
		System.out.println(dp[N*M][0]);
		
		br.close();
		bw.close();
		sc.close();
	}
}