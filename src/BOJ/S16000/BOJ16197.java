import java.io.*;
import java.util.*;

public class BOJ16197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	
	static int N, M;
	static char[][] board;
	
	static class Node{
		public int cnt;
		public int[][] coin;
		public Node(){
			this.cnt = 0;
			this.coin = new int[2][2];
		}
		public Node(int cnt, int[][] coin){
			this.cnt = cnt;
			this.coin = coin;
		}
	}
	
	static boolean isPossible(int[] coin){
		return 1<=coin[0]&&coin[0]<=N && 1<=coin[1]&&coin[1]<=M;
	}
	
	static int removeCoinCnt(int[][] coin){
		int res = 0;
		for(int i=0; i<2; ++i){
			if(!isPossible(coin[i])) ++res;
		}
		return res;
	}
	
	public static void BOJ16197 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N+2][];
		board[0] = " ".repeat(M+2).toCharArray();
		board[N+1] = " ".repeat(M+2).toCharArray();
		Node start = new Node();
		for(int i=1, idx=0; i<=N; ++i){
			board[i] = (" " + br.readLine() + " ").toCharArray();
			for(int j=1; j<=M; ++j){
				if(board[i][j] == 'o'){
					start.coin[idx][0] = i;
					start.coin[idx][1] = j;
					++idx;
					
					board[i][j] = '.';
				}
			}
		}
		
		for(int i=0; i<=N+1; ++i){
			for(int j=0; j<=M+1; ++j)
				System.out.print(board[i][j]);
			System.out.println();
		}
		
		List<Node> list = new ArrayList<>();
		list.add(start);
		boolean[][][][] visit = new boolean[N+2][M+2][N+2][M+2];
		int res = -1;
		while(!list.isEmpty()){
			Node iter = list.remove(0);
			int cnt = iter.cnt;
			int[][] coin = iter.coin;
			
			if(cnt > 10) break;
			
			int removeCoinCnt = removeCoinCnt(coin);
			if(removeCoinCnt == 1){
				res = cnt;
//				System.out.printf("(%d,%d), (%d,%d)\n", coin[0][0], coin[0][1], coin[1][0], coin[1][1]);
				break;
			}
			
			if(visit[coin[0][0]][coin[0][1]][coin[1][0]][coin[1][1]]) continue;
			visit[coin[0][0]][coin[0][1]][coin[1][0]][coin[1][1]] = true;
			
			if(removeCoinCnt == 2) continue;
			if(coin[0][0] == coin[1][0] && coin[0][1] == coin[1][1]) continue;
			
			for(int i=0; i<4; ++i){
				int nr1 = coin[0][0] + RD[i];
				int nc1 = coin[0][1] + CD[i];
				if(board[nr1][nc1] == '#'){
					nr1 -= RD[i];
					nc1 -= CD[i];
				}
				int nr2 = coin[1][0] + RD[i];
				int nc2 = coin[1][1] + CD[i];
				if(board[nr2][nc2] == '#'){
					nr2 -= RD[i];
					nc2 -= CD[i];
				}
				if(visit[nr1][nc1][nr2][nc2]) continue;
				list.add(new Node(cnt+1, new int[][]{{nr1,nc1}, {nr2,nc2}}));
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}