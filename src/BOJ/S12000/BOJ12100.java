package BOJ.S12000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12100 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int[][] base;
	
	public static void BOJ12100(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		base = new int[N][N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				base[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(game2048(0, base));
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int game2048(int idx, int[][] arr){
		if(idx == 5){
			return getMaxNum(arr);
		}
		
//		if(idx == 1 || idx == 2){
//			System.out.println("--------------------");
//			System.out.println(idx);
//			print(arr);
//			System.out.println("--------------------");
//		}
		
		int up = game2048(idx+1, up(arr));
		int down = game2048(idx+1, down(arr));
		int left = game2048(idx+1, left(arr));
		int right = game2048(idx+1, right(arr));
		return Math.max(Math.max(up, down), Math.max(left, right));
	}
	
	public static void print(int[][] arr){
//		System.out.println("----------------------------------");
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println("----------------------------------");
	}
	
	public static int getMaxNum(int[][] arr){
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				max = Math.max(max, arr[i][j]);
			}
		}
		return max;
	}
	
	public static void changeNum(List<Integer> list){
		for(int i=0; i<list.size(); ++i){
			int n1 = list.get(i);
			if(list.size() > (i+1)){
				int n2 = list.get(i+1);
				if(n1 == n2){
					list.remove(i);
					list.remove(i);
					list.add(i, n1*2);
				}
			}
		}
	}
	public static int[][] up(int[][] arr){
		int[][] next = new int[N][N];
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
				}
			}
		}
		return next;
	}
	public static int[][] down(int[][] arr){
		int[][] next = new int[N][N];
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
				}
			}
		}
		return next;
	}
	public static int[][] left(int[][] arr){
		int[][] next = new int[N][N];
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
				}
			}
		}
		return next;
	}
	public static int[][] right(int[][] arr){
		int[][] next = new int[N][N];
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
				}
			}
		}
		return next;
	}
}