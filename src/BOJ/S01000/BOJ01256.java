import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ01256 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M;
	static long K, MAX = 1_000_000_007;
	static long[][] comb = new long[300][300];
	static{
		for(int i=0; i<=210; ++i){
			Arrays.fill(comb[i], -1);
		}
	}
	static long comb(int n, int r){
		if(r < 0 || n < r) return 1;
		if(n == r || r == 0) return comb[n][r] = 1;
		if(comb[n][r] != -1) return comb[n][r];
		long s1 = comb(n-1, r-1);
		long s2 = comb(n-1, r);
		if(s1 + s2 > 1_000_000_000L) return comb[n][r] = MAX;
		return comb[n][r] = s1 + s2;
	}
	
	static StringBuilder sb = new StringBuilder();
	static void makeStr(int n, int m, long k){
		long c = comb(n+m-1, n-1);
		if(n>0 && k <= c){
			sb.append("a");
			makeStr(n-1, m, k);
		}else if(m > 0){
			sb.append("z");
			makeStr(n, m-1, k-c);
		}
	}
	
	public static void BOJ01256(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextLong();
		
		if(comb(N+M, N) < K){
			System.out.println(-1);
			return;
		}
		
		makeStr(N, M, K);
		System.out.println(sb);
		
		br.close();
		bw.close();
		sc.close();
	}
}