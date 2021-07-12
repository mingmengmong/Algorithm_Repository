package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11025 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int K;
	
	public static void BOJ11025(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
//		System.out.println(josephus(N, K));
		
		int result = 1;
		for(int i=2; i<=N; ++i){
			result = (result + K - 1) % i + 1;
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int josephus(int n, int k){
		if(n == 1){
			return 1;
		}
		
		return (josephus(n-1, k) + k -1) % n + 1;
	}
}