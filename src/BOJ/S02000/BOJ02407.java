package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02407 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static BigInteger[][] arr;
	
	public static void BOJ02407(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new BigInteger[N+1][N+1];
		System.out.println(comb(N, M));
		
		sc.close();
		bw.close();
		br.close();
	}
	public static BigInteger comb(int n, int m){
		if(arr[n][m] != null){
			return arr[n][m];
		}
		if(m == 0 || m == n){
			return arr[n][m] = BigInteger.ONE;
		}
		
		return (arr[n][m] = (comb(n-1, m-1).add(comb(n-1, m))));
	}
}