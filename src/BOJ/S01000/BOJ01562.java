package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01562 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int MOD = 1000000000;
	public static int[][][] arr = new int[100][10][1<<10];
	static{
		for(int i=1; i<=9; ++i){
			arr[0][i][1<<i] = 1;
		}
	}
	
	public static int N;
	
	public static int[] di = {-1, 1};
	public static void dp(int n){
		if(n == N){
			return;
		}
		
		int pn = n - 1;
		for(int i=0; i<10; ++i){
			for(int k=0; k<2; ++k) {
				try {
					for (int j = 0; j < 1024; ++j) {
						int idx = j | (1 << i);
						arr[n][i][idx] += arr[pn][i+di[k]][j];
						arr[n][i][idx] %= MOD;
					}
				} catch (Exception e) {}
			}
		}
		dp(n+1);
	}
	
	public static void BOJ01562(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input2")));
		
		N = Integer.parseInt(br.readLine());
		
		if(N < 10){
			System.out.println(0);
			return;
		}
		
		dp(1);
		int cnt = 0;
		--N;
		for(int j=0; j<10; ++j){
			cnt += arr[N][j][1023];
			cnt %= MOD;
		}
		System.out.println(cnt);
		
		sc.close();
		bw.close();
		br.close();
	}
}