import java.io.*;
import java.util.*;

public class BOJ01857 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int[] RD = {2,2,-2,-2,1,1,-1,-1}, CD = {1,-1,1,-1,2,-2,2,-2};
	static boolean isPossible(int r, int c){
		return 0<=r&&r<N && 0<=c&&c<M;
	}
	
	static class Node{
		int r,c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, MAX=30, sr,sc, er,ec;
	static int[][] board = new int[MAX+1][MAX+1];
	static int[][][][] G = new int[MAX+1][MAX+1][MAX+1][MAX+1];
	static long[][][][] GC = new long[MAX+1][MAX+1][MAX+1][MAX+1];
	
	static int[][] distance = new int[MAX+1][MAX+1];
	static long[][] cnt = new long[MAX+1][MAX+1];
	static {
		for (int i=0; i<=MAX; ++i) Arrays.fill(distance[i], -1);
	}
	
	public static void BOJ01857(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 3){
					sr = i;
					sc = j;
					board[i][j] = 0;
				}else if(board[i][j] == 4){
					er = i;
					ec = j;
					board[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j){
				// i,j 좌표에서 시작해 방석 1개로 갈수 있는 그래프 생성
				if(board[i][j] != 0) continue;
				G[i][j][i][j] = 1;
				
				List<Node> list = new LinkedList<>();
				list.add(new Node(i,j));
				while(!list.isEmpty()){
					Node iter = list.remove(0);
					int r = iter.r;
					int c = iter.c;
					for(int k=0; k<8; ++k){
						int nr = r + RD[k];
						int nc = c + CD[k];
						if(!isPossible(nr,nc)) continue;
						// 이미 방석이 있는경우만 1로 변경
						if(board[nr][nc] != 1) continue;
						if(G[i][j][nr][nc] != 0) continue;
						G[i][j][nr][nc] = 1;
						// 방석이 방석으로 갈 경우도 체크
						list.add(new Node(nr,nc));
					}
				}
				
				// END 방석을 포함한 방석 1개로 갈수 있는 그래프 생성
				
				// i,j 에서 방석 2개로 갈 수 있는 모든 길을 체크
				// 실제 bfs 에선 2개로 갈 수 있는 길만 탐색하면서 방석개수(distance) 배열을 +1 씩 하며 체크
				for(int r=0; r<N; ++r){
					for(int c=0; c<M; ++c){
						if(G[i][j][r][c] != 1) continue;
						
						// 1인 좌표들에서 8방향 탐색만
						for(int k=0; k<8; ++k){
							int nr = r + RD[k];
							int nc = c + CD[k];
							if(!isPossible(nr,nc)) continue;
							if(G[i][j][nr][nc] == 2){
								++GC[i][j][nr][nc];
								continue;
							}
							if(G[i][j][nr][nc] != 0) continue;
							if(board[nr][nc] != 0) continue;
							G[i][j][nr][nc] = 2;
							++GC[i][j][nr][nc];
						}
					}
				}
			}
		}
		
//		System.out.println(GC[1][0][0][4]);
		
		List<Node> list = new LinkedList<>();
		list.add(new Node(sr, sc));
		distance[sr][sc] = 0;
		cnt[sr][sc] = 1;
		while(!list.isEmpty()){
			Node iter = list.remove(0);
			int r = iter.r;
			int c = iter.c;
			
			for(int i=0; i<N; ++i){
				for(int j=0; j<M; ++j){
					if(G[r][c][i][j] != 2) continue;
					
					if(distance[i][j] == -1){
						distance[i][j] = distance[r][c] + 1;
						cnt[i][j] = cnt[r][c];
						list.add(new Node(i,j));
					}else if(distance[i][j] == distance[r][c]+1){
						cnt[i][j] += cnt[r][c];
					}
				}
			}
		}
		
		if(distance[er][ec] == -1) System.out.println(-1);
		else {
			System.out.println(distance[er][ec]-1);
			System.out.println(cnt[er][ec]);
		}
		
		br.close();
		bw.close();
//		sc.close();
	}
}