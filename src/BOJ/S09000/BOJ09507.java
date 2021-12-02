import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ09507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int TC;
	static int N, MAX=67;
	static long[] dp = new long[MAX+1];
	
	public static void BOJ09507(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4; i<=MAX; ++i){
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
		}
		
		TC = sc.nextInt();
		while(TC-- > 0){
			N = sc.nextInt();
			System.out.println(dp[N]);
		}
		
		
		br.close();
		bw.close();
		sc.close();
	}
}