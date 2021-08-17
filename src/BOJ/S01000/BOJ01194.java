package BOJ.S01000;
import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01194 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	
	static int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	static class Node{
		int r,c,idx, cost;
		public Node(int r, int c, int idx, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
			this.idx = idx;
		}
	}
	
	static int N, M, idxSize = 6;
	static char[][] board;
	static boolean[] idxArr = new boolean[idxSize];
	static boolean[][][] visit;
	// abcdef - 012345 - size=6
	
	static boolean isPossible(int r, int c){
		return 0<=r&&r<N && 0<=c&&c<M;
	}
	
	static void makeIdxArr(int idx){
		Arrays.fill(idxArr, false);
		for(int i=0; i<idxSize; ++i){
			int ii = 1 << i;
			idxArr[i] = (ii & idx) != 0;
		}
	}
	
	static int idxArrToIdx(){
		int res = 0;
		for(int i=idxSize-1; i>=0; --i){
			res <<= 1;
			res += idxArr[i] ? 1 : 0;
		}
		return res;
	}
	
	public static void BOJ01194(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		//sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][];
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1,n2) -> Integer.compare(n1.cost, n2.cost));
		
		for(int i=0; i<N; ++i) {
			board[i] = br.readLine().toCharArray();
			for(int c=0; c<M; ++c)
				if(board[i][c] == '0'){
					pq.add(new Node(i,c,0,0));
				}
		}
		
		int res = -1;
		visit = new boolean[N][M][1<<idxSize];
		
		while(!pq.isEmpty()){
			Node iter = pq.poll();
			int r = iter.r;
			int c = iter.c;
			int idx = iter.idx;
			int cost = iter.cost;
			
			if(board[r][c] == '1'){
				res = cost;
				break;
			}
			
			if(visit[r][c][idx]) continue;
			visit[r][c][idx] = true;
			
			makeIdxArr(idx);
			if('a' <= board[r][c] && board[r][c] <= 'z'){
				idxArr[board[r][c]-'a'] = true;
				idx = idxArrToIdx();
				visit[r][c][idx] = true;
			}
			
			for(int i=0; i<4; ++i){
				int nr = r + RD[i];
				int nc = c + CD[i];
				if(!isPossible(nr,nc) || visit[nr][nc][idx] || board[nr][nc] == '#') continue;
				if('A' <= board[nr][nc] && board[nr][nc] <= 'Z' && !idxArr[board[nr][nc]-'A']) continue;
				pq.add(new Node(nr, nc, idx, cost+1));
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}