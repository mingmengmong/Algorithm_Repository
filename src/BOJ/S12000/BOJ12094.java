package BOJ.S12000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12094 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int max = 0;
	
	public static void BOJ12094(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input2")));
		/*
		3
		2 2 2
		4 4 4
		8 8 8
		 */
		
		int[] baseArr = new int[1025];
		for(int i=1, j=2; i<=10; ++i, j<<=1){
			baseArr[j] = i;
		}
		
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				board[i][j] = baseArr[Integer.parseInt(st.nextToken())];
				max = Math.max(board[i][j], max);
			}
		}
		
		game2048(board, 0);
		
		System.out.println((int) Math.pow(2,max));
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void game2048(int[][] board, int cnt){
		if(board == null)
			return;
		
		int newMax = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				max = Math.max(max, board[i][j]);
				newMax = Math.max(newMax, board[i][j]);
			}
		}
		
		if(cnt == 10)
			return;
		
		if(newMax + (10-cnt) <= max)
			return;
		
		game2048(up(board), cnt+1);
		game2048(down(board), cnt+1);
		game2048(left(board), cnt+1);
		game2048(right(board), cnt+1);
	}
	
	public static void changeNum(List<Integer> list){
		for(int i=0; i<list.size(); ++i){
			int n1 = list.get(i);
			if(list.size() > (i+1) && n1 == list.get(i+1)){
				list.remove(i+1);
				list.set(i, n1+1);
			}
		}
	}
	
	public static int[][] up(int[][] arr){
		int[][] next = new int[N][N];
		boolean isChange = false;
		for(int c=0; c<N; ++c){
			List<Integer> list = new ArrayList<>();
			for(int r=0; r<N; ++r){
				if(arr[r][c] > 0){
					list.add(arr[r][c]);
				}
			}
			if(!list.isEmpty()){
				changeNum(list);
				for(int r=0; r<list.size(); ++r){
					next[r][c] = list.get(r);
					if(arr[r][c] != next[r][c])
						isChange = true;
				}
			}
		}
		return isChange ? next : null;
	}
	public static int[][] down(int[][] arr){
		int[][] next = new int[N][N];
		boolean isChange = false;
		for(int c=0; c<N; ++c){
			List<Integer> list = new ArrayList<>();
			for(int r=N-1; r>=0; --r){
				if(arr[r][c] > 0){
					list.add(arr[r][c]);
				}
			}
			if(!list.isEmpty()){
				changeNum(list);
				for(int r=0; r<list.size(); ++r){
					next[N-1-r][c] = list.get(r);
					if(arr[r][c] != next[r][c])
						isChange = true;
				}
			}
		}
		return isChange ? next : null;
	}
	public static int[][] left(int[][] arr){
		int[][] next = new int[N][N];
		boolean isChange = false;
		for(int r=0; r<N; ++r){
			List<Integer> list = new ArrayList<>();
			for(int c=0; c<N; ++c){
				if(arr[r][c] > 0){
					list.add(arr[r][c]);
				}
			}
			if(!list.isEmpty()){
				changeNum(list);
				for(int c=0; c<list.size(); ++c){
					next[r][c] = list.get(c);
					if(arr[r][c] != next[r][c])
						isChange = true;
				}
			}
		}
		return isChange ? next : null;
	}
	public static int[][] right(int[][] arr){
		int[][] next = new int[N][N];
		boolean isChange = false;
		for(int r=0; r<N; ++r){
			List<Integer> list = new ArrayList<>();
			for(int c=N-1; c>=0; --c){
				if(arr[r][c] > 0){
					list.add(arr[r][c]);
				}
			}
			if(!list.isEmpty()){
				changeNum(list);
				for(int c=0; c<list.size(); ++c){
					next[r][N-1-c] = list.get(c);
					if(arr[r][c] != next[r][c])
						isChange = true;
				}
			}
		}
		return isChange ? next : null;
	}
}