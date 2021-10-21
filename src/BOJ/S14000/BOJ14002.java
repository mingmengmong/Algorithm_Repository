import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ14002 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX=1_000;
	static int[] arr = new int[MAX+1], dp = new int[MAX+1], prev = new int[MAX+1];
	
	public static void BOJ14002(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		int res = 0;
		int lastIdx = 0;
		for(int i=1; i<=N; ++i){
			arr[i] = sc.nextInt();
			dp[i] = 1;
			for(int j=1; j<i; ++j){
				if(arr[j] < arr[i]){
					if(dp[i] < dp[j]+1){
						dp[i] = dp[j]+1;
						prev[i] = j;
					}
				}
			}
			
			if(res < dp[i]){
				res = dp[i];
				lastIdx = i;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		while(lastIdx > 0){
			list.add(0, arr[lastIdx]);
			lastIdx = prev[lastIdx];
		}
		
		System.out.println(res);
		for(int i : list) System.out.printf("%d ", i);
		System.out.println();
		
		br.close();
		bw.close();
		sc.close();
	}
}