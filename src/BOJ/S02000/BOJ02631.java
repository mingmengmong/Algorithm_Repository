import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ02631 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX=1_000;
	static int[] arr = new int[MAX+1], dp = new int[MAX+1];
	
	public static void BOJ02631(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		int res = 0;
		for(int i=1; i<=N; ++i){
			arr[i] = sc.nextInt();
			dp[i] = 1;
			for(int j=1; j<i; ++j){
				if(arr[j] < arr[i]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			res = Math.max(res, dp[i]);
		}
		
		System.out.println(N-res);
		
		br.close();
		bw.close();
		sc.close();
	}
}