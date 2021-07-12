package BOJ.S20000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ20056 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int[] RD = {-1, -1, 0, 1, 1, 1, 0, -1}, CD = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static class FB{
		public int m, s, d;
		public FB(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	public static int N, MAXN = 50, M, K, now=0, next=1;
	public static List<FB>[][][] board = new List[2][MAXN][MAXN];
	static{
		for(int k=0; k<2; ++k)
			for(int i=0; i<MAXN; ++i)
				for(int j=0; j<MAXN; ++j)
					board[k][i][j] = new ArrayList<>();
			
	}
	
	public static void BOJ20056(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			board[now][r][c].add( new FB(m, s, d) );
		}
		
		while(K-- > 0){
			for(int r=0; r<N; ++r){
				for(int c=0; c<N; ++c){
					if(board[now][r][c].isEmpty()) continue;
					while(!board[now][r][c].isEmpty()){
						FB fb = board[now][r][c].remove(0);
						int nr = ((r + fb.s * RD[fb.d]) % N + N) % N;
						int nc = ((c + fb.s * CD[fb.d]) % N + N) % N;
						board[next][nr][nc].add(fb);
					}
				}
			}
			
			for(int r=0; r<N; ++r){
				for(int c=0; c<N; ++c){
					int size = board[next][r][c].size();
					if(size <= 1) continue;
					
					int m = 0;
					int s = 0;
					int d = -1;
					boolean flag = true;
					for(int i=0; i<size; ++i){
						FB fb = board[next][r][c].remove(0);
						if(flag) {
							if (d < 0) d = fb.d & 1;
							else if (d != (fb.d & 1)) flag = false;
						}
						
						m += fb.m;
						s += fb.s;
					}
					
					if(m < 5) continue;
					m /= 5;
					s /= size;
					d = flag ? 0 : 1;
					for(int i=0; i<4; ++i){
						board[next][r][c].add( new FB(m,s,d + 2*i) );
					}
				}
			}
			
			now ^= 1;
			next ^= 1;
		}
		
		int res = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j) {
				for (FB fb : board[now][i][j])
					res += fb.m;
			}
		}
		
		System.out.println(res);
		
		sc.close();
		bw.close();
		br.close();
	}
}