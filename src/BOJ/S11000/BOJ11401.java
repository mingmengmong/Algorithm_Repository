package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11401 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static long mod = 1000000007;
	
	public static void BOJ11401(String[] args) throws Exception {
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		if(K==0 || N==K){
			System.out.println(1);
			return;
		}
		
		long[] fact = new long[N+1];
		fact[0]=fact[1]=1;
		for(int i=2; i<=N; ++i){
			fact[i] = (fact[i-1] * (long) i) % mod;
		}
		
		long m = 1;
		long k = (fact[K] * fact[N-K]) % mod;
		long loop = mod-2;
		while(loop > 0){
			if(loop % 2 == 1){
				m *= k;
				m %= mod;
			}
			k *= k;
			k %= mod;
			loop /= 2;
		}
		
		long result = (m * fact[N]) % mod;
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}