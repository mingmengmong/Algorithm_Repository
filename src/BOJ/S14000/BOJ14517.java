package BOJ.S14000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14517 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX = 1_000, MOD = 10_007;
//	static int[][] dp = new int[MAX+1][MAX+1];
	static int[] dp2 = new int[MAX+1];
	
	public static void BOJ14517(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		char[] str = (" "+br.readLine()).toCharArray();
		N = str.length-1;
		
		for(int i=1; i<=N; ++i){
			for(int j=i; j<=N; ++j){
//				dp[i][j] = dp[i-1][j];
				if(str[i] == str[j]){
//					++dp[i][j];
					++dp2[j];
					for(int k=j+1; k<=N; ++k){
//						dp[i][j] += dp[i-1][k];
//						dp[i][j] %= MOD;
						
						dp2[j] += dp2[k];
						dp2[j] %= MOD;
					}
				}
			}
		}
		
		int res = 0;
		for(int i=1; i<=N; ++i) {
//			for(int j=1; j<=N; ++j) System.out.print(dp[i][j] + " ");
//			System.out.println();
			
//			res += dp[i][i];
//			res %= MOD;
			
			res += dp2[i];
			res %= MOD;
		}
		
//		for(int i=1; i<=N; ++i) System.out.print(dp2[i] + " ");
//		System.out.println();
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}