package BOJ.S01000;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01261 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int C, R;
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	
	public static void BOJ01261(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[R][C];
		int[][] result = new int[R][C];
		boolean[][] visit = new boolean[R][C];
		
		for(int i=0; i<R; ++i){
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<C; ++j){
				board[i][j] = str[j] - '0';
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> Integer.compare(n1.l, n2.l));
		pq.add(new Node(0, 0, 0));
		while(!pq.isEmpty()){
			Node node = pq.poll();
			int l = node.l;
			int r = node.r;
			int c = node.c;
			
			if(visit[r][c])
				continue;
			
			visit[r][c] = true;
			result[r][c] = l;
			
			if(r == (R-1) && c == (C-1))
				break;
			
			
			for(int i=0; i<4; ++i){
				try{
					int nr = r + rd[i];
					int nc = c + cd[i];
					if(!visit[nr][nc])
						pq.add(new Node(l + board[nr][nc], nr, nc));
				}catch (Exception e){}
			}
		}
		
		System.out.println(result[R-1][C-1]);

		sc.close();
		bw.close();
		br.close();
	}
	
	public static class Node{
		public int l;
		public int r;
		public int c;
		public Node(int l, int r, int c){
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}
}