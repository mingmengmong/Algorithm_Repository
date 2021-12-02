import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ01915 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, MAX=1_000;
	static char[][] arr = new char[MAX+1][MAX+1];
	static int[][] dp = new int[MAX+1][MAX+1];
	
	public static void BOJ01915(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		M = sc.nextInt();
		int res = 0;
		for(int i=1; i<=N; ++i){
			arr[i] = ("0" + sc.next()).toCharArray();
			for(int j=1; j<=M; ++j){
				if(arr[i][j] == '1'){
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
					res = Math.max(res, dp[i][j]);
				}
			}
		}
		
		System.out.println(res*res);
		
		br.close();
		bw.close();
		sc.close();
	}
}