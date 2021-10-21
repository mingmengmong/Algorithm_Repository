import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ01014 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int TC;
	static int N, M, size;
	static char[][] board;
	static int[][] dp;
	static boolean[][] visit;
	
	public static void BOJ01014 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new char[N+1][M];
			Arrays.fill(board[0], '.');
			for(int i=1; i<=N; ++i) board[i] = br.readLine().toCharArray();
			
			size = 1 << M;
			dp = new int[N+1][size];
			visit = new boolean[N+1][size];
			Arrays.fill(visit[0], true);
			
			for(int r=1; r<=N; ++r){
				aaa : for(int nowIdx=0; nowIdx<size; ++nowIdx){
					boolean[] now = new boolean[M];
					int oneCnt = 0;
					for(int i=0, ii=1; i<M; ++i, ii<<=1){
						if((ii&nowIdx) > 0){
							if(board[r][i] == 'x') continue aaa;
							if(i > 0 && now[i-1]) continue aaa;
							now[i] = true;
							++oneCnt;
						}
					}
					
					bbb : for(int prevIdx=0; prevIdx<size; ++prevIdx){
						if(!visit[r-1][prevIdx]) continue;
						for(int i=0, ii=1; i<M; ++i, ii<<=1){
							if((ii&prevIdx) > 0){
								if(i > 0 && now[i-1]) continue bbb;
								if(i < M-1 && now[i+1]) continue bbb;
							}
						}
						
						dp[r][nowIdx] = Math.max(dp[r][nowIdx], dp[r-1][prevIdx] + oneCnt);
						visit[r][nowIdx] = true;
					}
				}
			}
			
			int res = 0;
			for(int i=0; i<size; ++i){
				if(!visit[N][i]) continue;
				res = Math.max(res, dp[N][i]);
			}
			
			System.out.println(res);
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}