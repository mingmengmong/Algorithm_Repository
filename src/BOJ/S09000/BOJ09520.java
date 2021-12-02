import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ09520 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX=1_500;
	static int[][] arr = new int[MAX+1][MAX+1], dp = new int[MAX+1][MAX+1];
	static{
		for(int i=0; i<=MAX; ++i)
			Arrays.fill(dp[i], -1);
	}
	
	static int dp(int l, int r){
		if(dp[l][r] >= 0) return dp[l][r];
		int n = Math.max(l,r) + 1;
		if(n == N) return 0;
		return dp[l][r] = Math.min(arr[n][l] + dp(n,r), dp(l,n) + arr[r][n]);
	}
	
	public static void BOJ09520(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dp(0,0));
		
		br.close();
		bw.close();
		sc.close();
	}
}