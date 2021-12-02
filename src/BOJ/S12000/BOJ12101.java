import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ12101 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, K, MAX=11;
	static int[] dp = new int[MAX+1];
	static char[] str = new char[MAX+1];
	
	static void make(int n, int k){
		if(n == 0) return;
		if(k <= dp[n-1]){
			str[n] = '1';
			make(n-1, k);
		}else if(n>=2 && k <= dp[n-1]+dp[n-2]){
			str[n] = '2';
			make(n-2, k-dp[n-1]);
		}else{
			str[n] = '3';
			make(n-3, k-dp[n-1]-dp[n-2]);
		}
	}
	
	
	public static void BOJ12101(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		K = sc.nextInt();
		dp[0] = 1;
		for(int i=1; i<=11; ++i){
			dp[i] = dp[i-1];
			if(i>=2) dp[i] += dp[i-2];
			if(i>=3) dp[i] += dp[i-3];
		}
		
		if(K > dp[N]){
			System.out.println(-1);
			return;
		}
		
		make(N, K);
		String res = String.valueOf(str[N]);
		for(int i=N-1; i>0; --i){
			if(str[i] == 0) continue;
			res += "+" + str[i];
		}
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}