import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ02169 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, MAX=1_000;
	static int[][] arr = new int[MAX+1][MAX+1],
			dp1 = new int[MAX+1][MAX+1],    // move right
			dp2 = new int[MAX+1][MAX+1],    // move left
			dp3 = new int[MAX+1][MAX+1];    // move all
	
	public static void BOJ02169(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 1행만 초기화
		// 무조껀 밟는걸로 생각해야함.
		for(int j=1; j<=M; ++j){
			arr[1][j] = Integer.parseInt(st.nextToken());
			dp1[1][j] = dp1[1][j-1] + arr[1][j];
			dp3[1][j] = dp1[1][j];
		}
		
		for(int i=2; i<=N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp1[i][j] = dp3[i-1][j] + arr[i][j];
				dp2[i][j] = dp3[i-1][j] + arr[i][j];
				dp3[i][j] = dp3[i-1][j] + arr[i][j];
			}
			
			for(int j=2; j<=M; ++j){
				dp1[i][j] = Math.max(dp1[i][j], dp1[i][j-1] + arr[i][j]);
			}
			
			for(int j=M-1; j>=1; --j){
				dp2[i][j] = Math.max(dp2[i][j], dp2[i][j+1] + arr[i][j]);
			}
			
			for(int j=1; j<=M; ++j){
				dp3[i][j] = Math.max(dp3[i][j], Math.max(dp1[i][j], dp2[i][j]));
			}
		}
		
		System.out.println("arr");
		for(int i=1; i<=N; ++i){
			for(int j=1; j<=M; ++j) System.out.printf("%d ", arr[i][j]);
			System.out.println();
		}
		System.out.println();
		System.out.println("dp3");
		for(int i=1; i<=N; ++i){
			for(int j=1; j<=M; ++j) System.out.printf("%d ", dp3[i][j]);
			System.out.println();
		}
		System.out.println();
		System.out.println("dp1");
		for(int i=1; i<=N; ++i){
			for(int j=1; j<=M; ++j) System.out.printf("%d ", dp1[i][j]);
			System.out.println();
		}
		System.out.println();
		System.out.println("dp2");
		for(int i=1; i<=N; ++i){
			for(int j=1; j<=M; ++j) System.out.printf("%d ", dp2[i][j]);
			System.out.println();
		}
		
		
		
		System.out.println(dp3[N][M]);
		
		br.close();
		bw.close();
		sc.close();
	}
}