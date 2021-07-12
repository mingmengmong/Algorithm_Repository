package BOJ.S15000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15824 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN = 300_000, MOD = 1_000_000_007;
	public static long[] arr, pow2 = new long[MAXN+1];
	static{
		pow2[0] = 1;
		for(int i=1; i<=MAXN; ++i) pow2[i] = (pow2[i-1] << 1) % MOD;
	}
	
	public static void BOJ15824(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		
		int res = 0;
		for(int i=0; i<N; ++i){
//			long n = arr[i];
//			if(i > 0){
//				 최대값일경우의 부분집합
//				 res = + (Math.pow(2, i) - 1) * n;
//			}
//			if(i < N-1){
//				 최소값일경우의 부분집합
//				 res = - (Math.pow(2, N-1-i) - 1) * n;
//			}
			// res += (Math.pow(2, i) - Math.pow(2, N-1-i)) * n
			res += (((pow2[i] - pow2[N-1-i] + MOD) % MOD) * arr[i]) % MOD;
			res %= MOD;
		}
		
		System.out.println((res + MOD) % MOD);
		
		sc.close();
		bw.close();
		br.close();
	}
}