package BOJ.S17000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17404 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAX=1_000, MAX2=10_000_000;
	public static int[] R = new int[MAX+1], G = new int[MAX+1], B = new int[MAX+1];
	/**
	RR
	RG
	RB
	GR
	GG
	GB
	BR
	BG
	BB
	 */
	public static int[][] dp = new int[MAX+1][9];
	
	public static void BOJ17404(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = dp[0][1] = dp[0][2] = R[0];
		dp[0][3] = dp[0][4] = dp[0][5] = G[0];
		dp[0][6] = dp[0][7] = dp[0][8] = B[0];
		
		dp[1][0] = MAX2;
		dp[1][1] = dp[0][1] + G[1];
		dp[1][2] = dp[0][2] + B[1];
		
		dp[1][3] = dp[0][3] + R[1];
		dp[1][4] = MAX2;
		dp[1][5] = dp[0][5] + B[1];
		
		dp[1][6] = dp[0][6] + R[1];
		dp[1][7] = dp[0][7] + G[1];
		dp[1][8] = MAX2;
		
		if(N > 2){
			for(int i=2; i<N-1; ++i){
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R[i];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G[i];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B[i];
				
				dp[i][3] = Math.min(dp[i-1][4], dp[i-1][5]) + R[i];
				dp[i][4] = Math.min(dp[i-1][3], dp[i-1][5]) + G[i];
				dp[i][5] = Math.min(dp[i-1][3], dp[i-1][4]) + B[i];
				
				dp[i][6] = Math.min(dp[i-1][7], dp[i-1][8]) + R[i];
				dp[i][7] = Math.min(dp[i-1][6], dp[i-1][8]) + G[i];
				dp[i][8] = Math.min(dp[i-1][6], dp[i-1][7]) + B[i];
			}
			dp[N-1][0] = MAX2;
			dp[N-1][1] = Math.min(dp[N-2][0], dp[N-2][2]) + G[N-1];
			dp[N-1][2] = Math.min(dp[N-2][0], dp[N-2][1]) + B[N-1];
			
			dp[N-1][3] = Math.min(dp[N-2][4], dp[N-2][5]) + R[N-1];
			dp[N-1][4] = MAX2;
			dp[N-1][5] = Math.min(dp[N-2][3], dp[N-2][4]) + B[N-1];
			
			dp[N-1][6] = Math.min(dp[N-2][7], dp[N-2][8]) + R[N-1];
			dp[N-1][7] = Math.min(dp[N-2][6], dp[N-2][8]) + G[N-1];
			dp[N-1][8] = MAX2;
		}
		
		int res = MAX2;
		for(int i=0; i<9; ++i){
			res = Math.min(res, dp[N-1][i]);
		}
		
		System.out.println(res);
		
		sc.close();
		bw.close();
		br.close();
	}
}
