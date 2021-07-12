package BOJ.S02000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02342 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN = 100_000;
	public static int[] arr = new int[MAXN+1];
	public static int[][][] dp = new int[5][5][MAXN+1];
	public static int[][] power = {
			{0, 2, 2, 2, 2},
			{0, 1, 3, 4, 3},
			{0, 3, 1, 3, 4},
			{0, 4, 3, 1, 3},
			{0, 3, 4, 3, 1}
	};
	
	static{
		for(int i=0; i<5; ++i) for(int j=0; j<5; ++j) for(int k=0; k<=MAXN; ++k) dp[i][j][k] = -1;
	}
	
	// top-down
	public static int dfs(int l, int r, int idx){
		if(dp[l][r][idx] != -1) return dp[l][r][idx];
		int n = arr[idx];
		if(l == n || r == n) return dp[l][r][idx] = 1 + dfs(l,r,idx+1);
		else return dp[l][r][idx] = Math.min(
				power[l][n] + dfs(n,r,idx+1),
				power[r][n] + dfs(l,n,idx+1)
		);
	}
	
	public static void BOJ02342(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		String[] inputs = br.readLine().split(" ");
		N = inputs.length - 1;
		for(int i=0; i<=N; ++i) arr[i] = Integer.parseInt(inputs[i]);
		for(int i=0; i<5; ++i) for(int j=0; j<5; ++j) dp[i][j][N] = 0;
		
		System.out.println(dfs(0,0,0));
		
		sc.close();
		bw.close();
		br.close();
	}
}
