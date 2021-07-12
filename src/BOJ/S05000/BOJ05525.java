package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ05525 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	
	public static void BOJ05525(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		int pnl = 2*N+1;
		// 'O' = 0, 'I' = 1
		int[][] arr = new int[2][pnl+1];
		for(int i=0; i<pnl; ++i){
			boolean b = i%2==0;
			arr[0][i] = b?0:(i+1);
			arr[1][i] = b?(i+1):1;
		}
		arr[0][pnl] = pnl-1;
		arr[1][pnl] = 1;
		
		int result = 0;
		int status = 0;
		for(int i=0; i<M; ++i){
			int n = str[i]=='O'?0:1;
			status = arr[n][status];
			if(status == pnl){
				++result;
			}
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}