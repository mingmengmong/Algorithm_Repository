package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01451 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int R, C;
	static int[][] board;
	
	public static void BOJ01451(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R+1][C+1];
		for(int i = 1; i<=R; ++i){
			char[] input = br.readLine().toCharArray();
			for(int j = 1; j<=C; ++j){
				board[i][j] = input[j-1] - '0';
				board[i][j] += board[i-1][j] + board[i][j-1] - board[i-1][j-1];
			}
		}
		
		long res = 0;
		
		for(int r = 1; r<R; ++r){
			for(int c = 1; c<C; ++c){
				/*
				area1 area2
				area3 area4
				 */
				long area1 = board[r][c];
				long area2 = board[r][C] - area1;
				long area3 = board[R][c] - area1;
				long area4 = board[R][C] - area1 - area2 - area3;
				res = Math.max(res, (area1+area2)*area3*area4);
				res = Math.max(res, (area1+area3)*area2*area4);
				res = Math.max(res, (area2+area4)*area1*area3);
				res = Math.max(res, (area3+area4)*area1*area2);
			}
		}
		
		for(int r1=1; r1<=R-2; ++r1){
			for(int r2=r1+1; r2<=R-1; ++r2){
				/*
				area1
				area2
				area3
				 */
				long area1 = board[r1][C];
				long area2 = board[r2][C] - area1;
				long area3 = board[R][C] - area2 - area1;
				res = Math.max(res, area1 * area2 * area3);
			}
		}
		
		for(int c1=1; c1<=C-2; ++c1){
			for(int c2=c1+1; c2<=C-1; ++c2){
				// area1 area2 area3
				long area1 = board[R][c1];
				long area2 = board[R][c2] - area1;
				long area3 = board[R][C] - area2 - area1;
				res = Math.max(res, area1*area2*area3);
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}