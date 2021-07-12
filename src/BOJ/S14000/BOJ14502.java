package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14502 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int[][] changeArr;
	
	public static void BOJ14502(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				int n = Integer.parseInt(st.nextToken());
				arr[i][j] = n;
				if(n == 0){
					list.add(i*M+j);
				}
			}
		}
		
		for(int i=0; i<wallSize; ++i){
			wallList[i][0] = -1;
		}
		
		int listSize = list.size();
		setWallList(list, listSize, 0, 0, new int[3]);
		
		changeArr = new int[N][M];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<index; ++i){
			for(int r=0; r<N; ++r){
				for(int c=0; c<M; ++c){
					changeArr[r][c] = arr[r][c];
				}
			}
			for(int j=0; j<3; ++j){
				int r = wallList[i][j] / M;
				int c = wallList[i][j] % M;
				changeArr[r][c] = 1;
			}
			
			int sum = 0;
			for(int r=0; r<N; ++r){
				for(int c=0; c<M; ++c){
					if(changeArr[r][c] == 0){
						int result = bfs(r, c);
						if(result > 0){
//							System.out.println("------------------");
//							System.out.printf("(%d, %d)\n", sum, result);
//							for(int rr=0; rr<N; ++rr){
//								for(int cc=0; cc<M; ++cc){
//									System.out.print(changeArr[rr][cc] + " ");
//								}
//								System.out.println();
//							}
//							System.out.println("------------------");
							sum += result;
						}
					}
				}
			}
			max = Math.max(sum, max);
		}
		System.out.println(max);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int wallSize = 40000;
	public static int[][] wallList = new int[wallSize][3];
	public static int index = 0;
	public static void setWallList(List<Integer> list, int size, int idx, int p, int[] result){
		if(p == 3){
			for(int i=0; i<3; ++i){
				wallList[index][i] = result[i];
			}
			++index;
			return;
		}
		
		for(int i=idx; i<size; ++i){
			result[p] = list.get(i);
			setWallList(list, size, i+1, p+1, result);
		}
	}
	
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
//	public static int dfs(int r, int c){
//		int cnt = 0;
//		boolean n = false;
//		changeArr[r][c] = 3;
//		for(int i=0; i<4; ++i){
//			int nr = r + rd[i];
//			int nc = c + cd[i];
//			if(nr < 0 || nr == N || nc < 0 || nc == M){
//				continue;
//			}
//			if(changeArr[nr][nc] == 2){
//				return -1;
//			}else if(changeArr[nr][nc] == 0){
//				int result = dfs(nr, nc);
//				if(result == -1){
//					return -1;
//				}else{
//					cnt += result;
//				}
//			}
//		}
//		return cnt + 1;
//	}
	
	public static class Node{
		public int r;
		public int c;
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static int bfs(int startRow, int startCol){
		int cnt = 0;
		boolean isVirus = false;
		List<Node> list = new ArrayList<>();
		list.add(new Node(startRow, startCol));
		changeArr[startRow][startCol] = 3;
		while(!list.isEmpty()){
			Node n = list.remove(0);
			int r = n.r;
			int c = n.c;
			++cnt;
			for(int i=0; i<4; ++i){
				int nr = r + rd[i];
				int nc = c + cd[i];
				if(nr < 0 || nr == N || nc < 0 || nc == M){
					continue;
				}
				if(changeArr[nr][nc] == 2){
					isVirus = true;
				}else if(changeArr[nr][nc] == 0){
					list.add(new Node(nr, nc));
					changeArr[nr][nc] = 3;
				}else{
					continue;
				}
			}
		}
		
		return isVirus ? -1 : cnt;
	}
}