import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ09376 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static class Node{
		int r,c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	static boolean isPossible(int r, int c){
		return 0<=r&&r<=N+1 && 0<=c&&c<=M+1;
	}
	
	static int TC;
	static int N, M;
	static char[][] board;
	static int[][] start;
	static int[][][] arr;
	
	public static void BOJ09376(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new char[N+2][];
			arr = new int[3][N+2][M+2];
			start = new int[3][2];
			
			board[0] = ".".repeat(M+2).toCharArray();
			board[N+1] = ".".repeat(M+2).toCharArray();
			
			for(int i=1, idx=1; i<=N; ++i){
				board[i] = ("." + br.readLine() + ".").toCharArray();
				for(int j=1; j<=M; ++j){
					if(board[i][j] == '$'){
						board[i][j] = '.';
						start[idx][0] = i;
						start[idx][1] = j;
						++idx;
					}
				}
			}
			
			for(int k=0; k<3; ++k) {
				for (int i = 0; i <= N + 1; ++i) {
					Arrays.fill(arr[k][i], -1);
				}
			}
			
			for(int k=0; k<3; ++k) {
//				List<Node> list = new LinkedList<>();
				Deque<Node> dq = new ArrayDeque<>();
				int sr = start[k][0];
				int sc = start[k][1];
				arr[k][sr][sc] = 0;
//				list.add(new Node(sr, sc));
				dq.add(new Node(sr,sc));
//				while(!list.isEmpty()){
				while(!dq.isEmpty()){
//					Node iter = list.remove(0);
					Node iter = dq.pollFirst();
					int r = iter.r;
					int c = iter.c;
					
					for(int i=0; i<4; ++i){
						int nr = r + RD[i];
						int nc = c + CD[i];
						if(!isPossible(nr, nc)) continue;
						if(arr[k][nr][nc] >= 0) continue;
						if(board[nr][nc] == '*')continue;
						
						if(board[nr][nc] == '.'){
							arr[k][nr][nc] = arr[k][r][c];
//							list.add(0, new Node(nr,nc));
							dq.addFirst(new Node(nr,nc));
						}else if(board[nr][nc] == '#'){
							arr[k][nr][nc] = arr[k][r][c] + 1;
//							list.add(new Node(nr,nc));
							dq.addLast(new Node(nr,nc));
						}
					}
				}
			}
			
			int res = Integer.MAX_VALUE;
			for(int i=0; i<=N+1; ++i){
				for(int j=0; j<=M+1; ++j){
					if(board[i][j] == '*') continue;
					if(arr[0][i][j] < 0 || arr[1][i][j] < 0 || arr[2][i][j] < 0) continue;
					int sum = arr[0][i][j] + arr[1][i][j] + arr[2][i][j];
					if(board[i][j] == '#') sum -= 2;
					res = Math.min(res, sum);
				}
			}
			
			System.out.println(res);
		}
		
		
		br.close();
		bw.close();
//		sc.close();
	}
}