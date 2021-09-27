import java.io.*;
import java.util.*;

public class BOJ01096 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N,M;
	
	static int[][] dp = new int[12][12];
	static int[][] board = new int[12][12];
	static int[] arr = new int[12];
	static Set<Integer> row = new HashSet<>(), col = new HashSet<>();
	
	static void init(int d, int n, Set<Integer> set) {
		for (int i=0; i<n; ++i) set.add(dp[d][i]);
		
		// i 번째를 접겠다.
		// 접은애 기준 양옆으로 idx 증가
		for (int i=1; i<n; ++i) {
			// 초기화
			for (int j=0; j<n; ++j)
				dp[d+1][j] = 0;
			
			for (int j=i; j<n; ++j) {
				dp[d+1][j-i] |= dp[d][j];
			}
			for (int j=i-1; j>=0; --j) {
				dp[d+1][i-1 - j] |= dp[d][j];
			}
			init(d + 1, Math.max(i, n - i), set);
		}
	}
	
	
	public static void BOJ01096(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		M = sc.nextInt();
		for(int r=0; r<N; ++r){
			for(int c=0; c<M; ++c)
				board[r][c] = sc.nextInt();
		}
		
		for (int i = 0; i < N; ++i) dp[0][i] = (1 << i);
		init(0, N, row);
		for (int i = 0; i < M; ++i) dp[0][i] = (1 << i);
		init(0, M, col);
		
		int res = Integer.MIN_VALUE;
		for(int r : row){
			Arrays.fill(arr, 0);
			for(int i=0; i<N; ++i){
				if(((1<<i) & r) > 0){
					for(int j=0; j<M; ++j){
						arr[j] += board[i][j];
					}
				}
			}
			
			for(int c : col){
				int sum = 0;
				for(int i=0; i<M; ++i){
					if(((1<<i) & c) > 0)
						sum += arr[i];
				}
				res = Math.max(res, sum);
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}