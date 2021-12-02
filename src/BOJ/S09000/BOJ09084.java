import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int TC;
	static int N, K;
	static int[] coin;
	static int[][] dp;
	
	public static void BOJ09084(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			N = Integer.parseInt(br.readLine());
			coin = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; ++i) coin[i] = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(br.readLine());
			dp = new int[N+1][K+1];
			for(int i=1; i<=N; ++i){
				int c = coin[i];
				if(c <= K) dp[i][c] = 1;
				for(int j=0; j<=K; ++j){
					dp[i][j] += dp[i-1][j];
					if(j-c >= 0) dp[i][j] += dp[i][j-c];
				}
			}
			
			System.out.println(dp[N][K]);
		}
		
		
		br.close();
		bw.close();
		sc.close();
	}
}