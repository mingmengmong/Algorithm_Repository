import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ13398 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX=100_000;
	static int[] arr = new int[MAX+1], dp1 = new int[MAX+1], dp2 = new int[MAX+1];
	
	public static void BOJ13398(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		dp1[0] = dp2[0] = arr[0];
		int res = arr[0];
		for(int i=1; i<N; ++i){
			dp1[i] = Math.max(0, dp1[i-1]) + arr[i];
			dp2[i] = Math.max(dp1[i-1], dp2[i-1]+arr[i]);
			res = Math.max(res, Math.max(dp1[i], dp2[i]));
		}
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}