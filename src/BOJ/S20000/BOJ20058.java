package BOJ.S20000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ20058 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	public static int N, NN, M, now=0, next=1;
	public static int[][][] board;
	public static boolean[][] visit;
	
	public static void BOJ20058(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		NN = (int) Math.pow(2, N);
		board = new int[NN+2][NN+2][2];
		for(int i=1; i<=NN; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=NN; ++j){
				board[i][j][now] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int m=0; m<M; ++m){
			int s = Integer.parseInt(st.nextToken());
			int ss = (int) Math.pow(2, s);
			int loop = NN/ss;
			for(int i=0; i<loop; ++i){
				for(int j=0; j<loop; ++j){
					rotateBoard(1+i*ss,1+j*ss,ss);
				}
			}
			
			for(int i=1; i<=NN; ++i){
				for(int j=1; j<=NN; ++j){
					boolean flag = true;
					int cnt = 0;
					for(int k=0; flag && k<4; ++k){
						int nr = i + RD[k];
						int nc = j + CD[k];
						if(board[nr][nc][now] == 0)
							++cnt;
						if(cnt >= 2)
							flag = false;
					}
					board[i][j][next] = Math.max(0, board[i][j][now] + (flag ? 0 : -1));
				}
			}
			
			now ^= 1;
			next ^= 1;
		}
		
		init();
		int sum = 0;
		int max = 0;
		for(int i=1; i<=NN; ++i){
			for(int j=1; j<=NN; ++j){
				sum += board[i][j][now];
				if(!visit[i][j] && board[i][j][now] != 0){
					max = Math.max(max, dfs(i,j));
				}
			}
		}
		
		System.out.println(sum);
		System.out.println(max);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void init(){
		visit = new boolean[NN+2][NN+2];
		for(int i=0; i<NN+2; ++i){
			visit[0][i] = true;
			visit[i][0] = true;
			visit[NN+1][i] = true;
			visit[i][NN+1] = true;
		}
	}
	
	public static int dfs(int r, int c){
		if(visit[r][c]) return 0;
		visit[r][c] = true;
		int cnt = 1;
		for(int i=0; i<4; ++i){
			int nr = r + RD[i];
			int nc = c + CD[i];
			if(board[nr][nc][now] == 0 || visit[nr][nc]) continue;
			cnt += dfs(nr, nc);
		}
		return cnt;
	}
	
	// mini box left top point
	public static void rotateBoard(int r, int c, int size){
		if(size <= 1) return;
		rotateBoard(r+1, c+1, size-2);
		
		int top = r;
		int bottom = r + size - 1;
		int left = c;
		int right = c + size - 1;
		
		for(int i=0; i<size-1; ++i){
			swap(top, c+i, top+i, right);
		}
		for(int i=0; i<size-1; ++i){
			swap(bottom-i, left, top, c+i);
		}
		for(int i=0; i<size-1; ++i){
			swap(bottom, right-i, bottom-i, left);
		}
//		for(int i=0; i<size-1; ++i){
//			swap(top+i, right, bottom, right-i);
//		}
	}
	
	public static void swap(int r1, int c1, int r2, int c2){
		int tmp = board[r1][c1][now];
		board[r1][c1][now] = board[r2][c2][now];
		board[r2][c2][now] = tmp;
	}
}