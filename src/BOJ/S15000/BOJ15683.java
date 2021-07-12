package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15683 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static class Node{
		public int row;
		public int col;
		public int cameraNum;
		public Node(int r, int c, int cn){
			row = r;
			col = c;
			cameraNum = cn;
		}
	}
	
	public static int N;
	public static int M;
	
	public static void BOJ15683(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr= new int[N][M];
		List<Node> camera = new ArrayList<>();
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				int n = Integer.parseInt(st.nextToken());
				arr[i][j] = n;
				if(1 <= n && n <= 5){
					if(n == 5){
						camera.add(0, new Node(i,j,n));
					}else{
						camera.add(new Node(i,j,n));
					}
				}
			}
		}
		
		int result = find(arr, camera, 0);
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	// 방향 : 아래, 오른쪽, 위, 왼
	public static int[] rd = {1, 0, -1,  0};
	public static int[] cd = {0 ,1,  0, -1};
	
	// 카메라 번호별 감시 방향을 표현한 배열
	public static int[][][] cameraDirection = {
			{},
			{{0},{1},{2},{3}},
			{{0,2},{1,3}},
			{{0,1},{1,2},{2,3},{3,0}},
			{{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
			{{0,1,2,3}}
	};
	
	public static int find(int[][] board, List<Node> list, int idx){
		// 탐색을 다하면 0의 갯수를 샌 후 해당값을 리턴
		if(list.size() == idx){
			int result = 0;
			// 해당 주석은 확인용 출력
//			System.out.println("----------------------------");
			for(int i=0; i<N; ++i){
				for(int j=0; j<M; ++j){
					if(board[i][j] == 0){
						++result;
					}
//					System.out.printf("%2d ",board[i][j]);
				}
//				System.out.println();
			}
//			System.out.println("----------------------------");
			return result;
		}
		
		Node node = list.get(idx);
		int cn = node.cameraNum;
		int r = node.row;
		int c = node.col;
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<cameraDirection[cn].length; ++i){
			int[][] copyBoard = copyBoard(board);
			int[] dArr = cameraDirection[cn][i];
//			System.out.println(Arrays.toString(dArr));
			for(int d : dArr){
				int nr = r;
				int nc = c;
				while(true) {
					nr += rd[d];
					nc += cd[d];
					if (nr < 0 || nr == N || nc < 0 || nc == M) {
						break;
					}
					if (copyBoard[nr][nc] == 0) {
						copyBoard[nr][nc] = -1;
					} else if (copyBoard[nr][nc] == 6) {
						break;
					}
				}
			}
			// 0의 개수가 가장 작은 경우를 리턴
			int result = find(copyBoard, list, idx+1);
			min = Math.min(min, result);
		}
		return min;
	}
	
	public static int[][] copyBoard(int[][] board){
		int[][] result = new int[N][M];
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j){
				result[i][j] = board[i][j];
			}
		}
		return result;
	}
}