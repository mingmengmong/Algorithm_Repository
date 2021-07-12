package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ17837 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int K;
	public static Node[] pieceArr;
	public static Board[][] board;
	
	public static int[] rd = {0,  0, -1, 1};
	public static int[] cd = {1, -1,  0, 0};
	
	public static class Board{
		public List<Node> nodeList;
		public int num;
		public Board(){}
		public Board(int num){
			this.num = num;
			init();
		}
		public void init(){
			nodeList = new ArrayList<>();
		}
		public String toString(){
			return nodeList.toString();
		}
	}
	
	public static class Node{
		public int n;
		public int r;
		public int c;
		public int d;
		
		public Node(int n, int r, int c, int d) {
			this.n = n;
			this.r = r;
			this.c = c;
			this.d = d;
		}
		public String toString(){
			return String.format("(%d, %d)",n,d);
		}
	}
	
	public static void BOJ17837(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new Board[N+2][N+2];
		pieceArr = new Node[K];
		for(int i=0; i<N+2; ++i){
			board[0][i] = new Board(2);
			board[i][0] = new Board(2);
			board[N+1][i] = new Board(2);
			board[i][N+1] = new Board(2);
		}
		for(int i=1; i<=N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; ++j){
				board[i][j] = new Board(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=0; i<K; ++i){
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			pieceArr[i] = new Node(i,r,c,d);
			board[r][c].nodeList.add(pieceArr[i]);
		}
		
//		for(int i=0; i<N+2; ++i){
//			for(int j=0; j<N+2; ++j){
//				System.out.print(board[i][j].num + "-" + board[i][j].nodeList.size() + " ");
//			}
//			System.out.println();
//		}
		
		for(int t=1; t<=1000; ++t){
			for(int i=0; i<K; ++i){
				Node node = pieceArr[i];
				int r = node.r;
				int c = node.c;
				int nr = r + rd[node.d];
				int nc = c + cd[node.d];
				int nextNum = board[nr][nc].num;
				
				if(nextNum == 2){
					node.d = changeDirection(node.d);
					nr = r + rd[node.d];
					nc = c + cd[node.d];
					nextNum = board[nr][nc].num;
					if(nextNum == 2){
						nr = r;
						nc = c;
					}
				}
				
				List<Node> nodeList = new ArrayList<>();
				boolean b = false;
				for(int j=0; j<board[r][c].nodeList.size();){
					if(b){
						nodeList.add(board[r][c].nodeList.remove(j));
					}else{
						if(board[r][c].nodeList.get(j).n == i){
							b = true;
							nodeList.add(board[r][c].nodeList.remove(j));
						}else{
							++j;
						}
					}
				}
				
				if(nextNum == 1){
					Collections.reverse(nodeList);
				}
				
				for(Node n : nodeList){
					pieceArr[n.n].r = nr;
					pieceArr[n.n].c = nc;
					board[nr][nc].nodeList.add(pieceArr[n.n]);
				}
				
//				if(t < 10) {
//					System.out.println("---------------------");
//					System.out.println(t + ": [" + nr + ", " + nc + "] - " + board[nr][nc]);
//					System.out.println("---------------------");
//				}
				
				if(board[nr][nc].nodeList.size() >= 4){
					System.out.println(t);
					return;
				}
			}
			
			for(int i=0; i<K; ++i){
				Node node = pieceArr[i];
				if(board[node.r][node.c].nodeList.size() >= 4){
					System.out.println(t);
					return;
				}
			}
			
			
		}
		System.out.println(-1);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int changeDirection(int d){
		return (d/2)*2 + (d+1)%2;
	}
}