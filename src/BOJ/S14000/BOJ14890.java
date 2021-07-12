package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14890 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	// up, down, right, left
	public static int[] rd = {-1, 1, 0,  0};
	public static int[] cd = { 0, 0, 1, -1};
	
	public static class Node{
		public int idx;
		public int direction;
		public Node(int i, int d){
			idx = i;
			direction = d;
		}
		public String toString(){
			return String.format("[%d, %d]", idx, direction);
		}
	}
	public static void BOJ14890(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		boolean[][] bArr = new boolean[N][N];
		for(int i=0; i<N; ++i){
			// 높이가 낮은애, 방향은 검색방향
			List<Node> rowList = new ArrayList<>();
			List<Node> colList = new ArrayList<>();
			boolean br = true;
			boolean bc = true;
			for(int j=0; j<(N-1); ++j){
				if(br) {
					int distance = Math.abs(arr[i][j] - arr[i][j + 1]);
					if (distance == 1) {
						if (arr[i][j] > arr[i][j + 1]) {
							rowList.add(new Node(j + 1, 2));
						} else {
							rowList.add(new Node(j, 3));
						}
					} else if (distance > 1) {
						br = false;
					}
				}
				
				if(bc) {
					int distance = Math.abs(arr[j][i] - arr[j + 1][i]);
					if (distance == 1) {
						if (arr[j][i] > arr[j + 1][i]) {
							colList.add(new Node(j + 1, 1));
						} else {
							colList.add(new Node(j, 0));
						}
					} else if (distance > 1) {
						bc = false;
					}
				}
			}
			
			if(bc) {
				boolean[] check = new boolean[N];
				for (Node node : colList) {
					if (!bc) {
						break;
					}
					
					int r = node.idx;
					int h = arr[r][i];
					int d = node.direction;
					
					if (check[r]) {
						bc = false;
						break;
					}
					check[r] = true;
					for (int j = 1; j < L; ++j) {
						int nr = r + j * rd[d];
						if (nr < 0 || nr >= N || arr[nr][i] != h || check[nr]) {
							bc = false;
							break;
						}
						check[nr] = true;
					}
				}
			}
			
			if(br){
				boolean[] check = new boolean[N];
				for (Node node : rowList) {
					if (!br) {
						break;
					}
					
					int c = node.idx;
					int h = arr[i][c];
					int d = node.direction;
					
					if (check[c]) {
						br = false;
						break;
					}
					check[c] = true;
					for (int j = 1; j < L; ++j) {
						int nc = c + j * cd[d];
						if (nc < 0 || nc >= N || arr[i][nc] != h || check[nc]) {
							br = false;
							break;
						}
						check[nc] = true;
					}
				}
			}
			
//			System.out.println("-----------------");
//			System.out.println("index : " + i);
//			System.out.println("rowList " + br);
//			System.out.println(rowList);
//			System.out.println("colList " + bc);
//			System.out.println(colList);
//			System.out.println("-----------------");
			
			result += br ? 1 : 0;
			result += bc ? 1 : 0;
		}
		System.out.println(result);
		
		
		sc.close();
		bw.close();
		br.close();
	}
}