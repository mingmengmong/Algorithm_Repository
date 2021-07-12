package BOJ.S03000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ03190 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] rd = {0, 1,  0, -1};
	public static int[] cd = {1, 0, -1,  0};
	
	public static class Node{
		public int r;
		public int c;
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void BOJ03190(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		boolean[][] appleArr = new boolean[N][N];
		for(int i=0; i<K; ++i){
			st = new StringTokenizer(br.readLine());
			appleArr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
		}
		
		K = Integer.parseInt(br.readLine());
		List<Integer> changeTime = new ArrayList<>();
		List<Boolean> changeDirection = new ArrayList<>();
		for(int i=0; i<K; ++i){
			st = new StringTokenizer(br.readLine());
			changeTime.add( Integer.parseInt(st.nextToken()) );
			changeDirection.add( "D".equals(st.nextToken()) );
		}
		
		List<Node> snake = new ArrayList<>();
		snake.add(new Node(0, 0));
		int sRow = 0;
		int sCol = 0;
		boolean isEatApple = true;
		int direction = 0;
		int time = 0;
		boolean isGameOver = false;
		while(!isGameOver){
			++time;
			if(isEatApple){
				isEatApple = false;
			}else{
				snake.remove(snake.size()-1);
			}
			sRow += rd[direction];
			sCol += cd[direction];
			
//			int[][] test = new int[N][N];
//			for(Node n : snake){
//				test[n.r][n.c] = 1;
//			}
//			for(int i=0; i<N; ++i){
//				for(int j=0; j<N; ++j){
//					if(appleArr[i][j]){
//						System.out.print("2 ");
//					}else {
//						System.out.print(test[i][j] + " ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.printf("next : (%d, %d)\n", sRow, sCol);
			
			if(sRow < 0 || sRow == N || sCol < 0 || sCol == N){
				isGameOver = true;
			}
			for(Node node : snake){
				int r = node.r;
				int c = node.c;
				if(r == sRow && c == sCol){
					isGameOver = true;
				}
			}
			if(isGameOver){
				break;
			}
			
			if(appleArr[sRow][sCol]){
				appleArr[sRow][sCol] = false;
				isEatApple = true;
			}
			
			snake.add(0, new Node(sRow, sCol));
			if(!changeTime.isEmpty()){
				int nextTime = changeTime.get(0);
				boolean nextDirection = changeDirection.get(0);
				if(time == nextTime){
					direction += (nextDirection ? 1 : -1) + 4;
					direction %= 4;
					
					changeTime.remove(0);
					changeDirection.remove(0);
				}
			}
		}
		System.out.println(time);
		
		sc.close();
		bw.close();
		br.close();
	}
}


/*

0 1 1 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
8 D
10 D
11 D
13 L

 */