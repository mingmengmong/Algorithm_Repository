import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ11048 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, MAX=1_000;
	static int[][] arr = new int[MAX+1][MAX+1], dp1 = new int[MAX+1][MAX+1], dp2 = new int[MAX+1][MAX+1];
	
	public static void BOJ11048(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp1[i][j] = arr[i][j];
				dp2[i][j] = arr[i][j];
			}
		}
		
		for(int j=1; j<M; ++j) dp2[0][j] = dp1[0][j] = dp1[0][j-1] + dp1[0][j];
		for(int i=1; i<N; ++i){
			for(int j=0; j<M; ++j){
				dp1[i][j] = dp2[i-1][j] + arr[i][j];
				if(j>0) dp1[i][j] = Math.max(dp1[i][j], dp1[i][j-1] + arr[i][j]);
				dp2[i][j] = dp1[i][j];
			}
		}
		
		System.out.println(dp2[N-1][M-1]);
		
		
		br.close();
		bw.close();
		sc.close();
	}
}