import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ16933 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static class Node{
		int r,c,w,l;
		// 0:낮, 1:밤
		int d;
		public Node(int r, int c, int w, int d, int l) {
			this.r = r;
			this.c = c;
			this.w = w;
			this.d = d;
			this.l = l;
		}
	}
	
	static int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	static int N, M, K;
	static int[][] arr = new int[1_000][1_000];
	static boolean[][][] visit = new boolean[1_000][1_000][11];
	
	static boolean isPossible(int r, int c){
		return 0<=r&&r<N && 0<=c&&c<M;
	}
	
	public static void BOJ16933(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; ++i){
			char[] ar = br.readLine().toCharArray();
			for(int j=0; j<M; ++j){
				arr[i][j] = ar[j] - '0';
			}
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>((n1, n2) -> Integer.compare(n1.l, n2.l));
		q.add(new Node(0, 0, 0, 0, 1));
		boolean flag = false;
		int res = 0;
		while(!q.isEmpty()){
			Node iter = q.poll();
			int r = iter.r;
			int c = iter.c;
			int w = iter.w;
			int d = iter.d;
			int l = iter.l;
			
			if(r == N-1 && c == M-1){
				res = l;
				flag = true;
				break;
			}
			
			if(visit[r][c][w]) continue;
			visit[r][c][w] = true;
			
			for(int i=0; i<4; ++i){
				int nr = r+RD[i];
				int nc = c+CD[i];
				if(!isPossible(nr,nc)) continue;
				
				int nw = w+arr[nr][nc];
				if(nw > K || visit[nr][nc][nw]) continue;
				
				if(arr[nr][nc] == 1) q.add(new Node(nr, nc, nw, 1, l+1+d));
				else q.add(new Node(nr, nc, nw, d^1, l+1));
			}
		}
		
		System.out.println(flag ? res : -1);
		
		br.close();
		bw.close();
		sc.close();
	}
}