package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15684 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int H;
	public static boolean[][] ladder;
	
	public static class Node{
		public int h;
		public int n;
		public Node(int h, int n){
			this.h = h;
			this.n = n;
		}
		public String toString(){
			return String.format("(%d, %d)", h+1, n);
		}
	}
	
	public static boolean result = true;

	public static void BOJ15684(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new boolean[H][N+1];

		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}

		int rCnt = 0;
		for(int i=1; i<=N; ++i){
			int r = ladderGame(ladder, i);
			if(i == r){
				++rCnt;
			}
//			System.out.println(i + " -> " + ladderGame(ladder, i));
		}
		if(rCnt == N){
			System.out.println(0);
			return;
		}
		
		List<Node> ladderList = new ArrayList<>();
		for(int i=0; i<H; ++i){
			for(int j=1; j<N; ++j){
				if(checkLadder(ladder, i, j)){
					ladderList.add(new Node(i, j));
				}
			}
		}
		int ladderSize = ladderList.size();
//		System.out.println(ladderList);
		
		for(int i=1; i<=3; ++i) {
			findLadder(ladder, ladderList, ladderSize, 0, i, 0);
		}
		
		if(result){
			System.out.println(-1);
		}else{
			bw.flush();
		}

		sc.close();
		bw.close();
		br.close();
	}

	public static int ladderGame(boolean[][] ladderBoard, int r){
		int p = r;
		for(int i=0; i<H; ++i){
			if(ladderBoard[i][p-1]){
				--p;
			}else if(ladderBoard[i][p]){
				++p;
			}
		}
		return p;
	}
	
	public static void findLadder(boolean[][] ladderBoard, List<Node> ladderList, int ladderSize, int idx, int size, int sIdx) throws Exception{
		if(idx == size){
			int cnt = 0;
			for(int i=1; i<=N; ++i){
				int r = ladderGame(ladderBoard, i);
				if(i == r){
					++cnt;
				}
			}
			if(cnt == N){
				result = false;
				bw.write(size + "\n");
			}
			return;
		}
		
		boolean[][] copyBoard = copyLadderBoard(ladderBoard);
		for(int i=sIdx; i<ladderSize && result; ++i){
			Node node = ladderList.get(i);
			int h = node.h;
			int n = node.n;
			if(checkLadder(copyBoard, h, n)){
				copyBoard[h][n] = true;
				findLadder(copyBoard, ladderList, ladderSize, idx+1, size, i+1);
				copyBoard[h][n] = false;
			}
		}
	}
	
	public static boolean checkLadder(boolean[][] ladderBoard, int h, int n){
		return !(ladderBoard[h][n-1] || ladderBoard[h][n] || ladderBoard[h][n+1]);
	}
	
	public static boolean[][] copyLadderBoard(boolean[][] ladderBoard){
		boolean[][] result = new boolean[H][N+1];
		for(int h=0; h<H; ++h){
			for(int n=1; n<N; ++n){
				result[h][n] = ladderBoard[h][n];
			}
		}
		return result;
	}
}