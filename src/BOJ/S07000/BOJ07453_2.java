package BOJ.S07000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ07453_2 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, NN, MAXN = 4_000;
	public static int[] A, B, C, D, AB;
	static{
		A = new int[MAXN];
		B = new int[MAXN];
		C = new int[MAXN];
		D = new int[MAXN];
	}
	
	public static void BOJ07453_2(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		N = Integer.parseInt(br.readLine());
		NN = N*N;
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		AB = new int[NN];
		for(int i=0, idx=0; i<N; ++i){
			for(int j=0; j<N; ++j, ++idx){
				AB[idx] = -(A[i] + B[j]);
			}
		}
		
		Arrays.sort(AB);
		
		long res = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				int cd = C[i] + D[j];
				res += lowerBound(cd+1, 0, NN) - lowerBound(cd, 0, NN);
			}
		}
		
		System.out.println(res);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int lowerBound(int t, int s, int e){
		while(s < e){
			int m = (s+e) >>> 1;
			int mm = AB[m];
			if(t <= mm) e = m;
			else s = m+1;
		}
		return s;
	}
}