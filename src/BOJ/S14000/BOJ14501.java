package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14501 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ14501(String[] args) throws Exception {
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i=0; i<N; ++i){
			int t = sc.nextInt();
			int p = sc.nextInt();
			int nt = i+t;
			
			for(int j=0; j<=i; ++j){
				arr[i] = Math.max(arr[i], arr[j]);
			}
			
//			bw.write(String.format("%d : %d, %d, %d\n", i, t, p, nt));
			if(nt <= N){
				int n = arr[i] + p;
				int max = 0;
				for(int j=0; j<nt; ++j){
					max = Math.max(max, arr[j]);
				}
				arr[nt] = Math.max(arr[nt], Math.max(max, n));
//				bw.write(String.format("if - %d, %d => %d\n",n,max,arr[nt]));
			}
		}
		for(int i=0; i<=N; ++i){
			arr[N] = Math.max(arr[N], arr[i]);
		}
		
		System.out.println(arr[N]);
		
		sc.close();
		bw.close();
		br.close();
	}
}