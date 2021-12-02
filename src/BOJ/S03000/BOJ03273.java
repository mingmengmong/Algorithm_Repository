import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ03273 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, K;
	static int[] arr = new int[100_001];
	static long[] cnt = new long[2_000_001];
	
	public static void BOJ03273(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		long res = 0;
		for(int i=0; i<N; ++i){
			int n = K - arr[i];
			if(n <= 0) continue;
			res += cnt[n];
			++cnt[arr[i]];
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}