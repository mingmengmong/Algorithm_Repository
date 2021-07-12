package BOJ.S01000;
import java.io.*;
import java.util.*;

public class BOJ01799 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN=10, NN;
	public static int[] res = new int[2];
	// -1: 벽, 0: 놓을수 있음, 1: 다른비숍의 라인, 2: 비숍
	public static int[][] arr = new int[MAXN][MAXN];
	public static List<Integer>[] board = new ArrayList[2];
	static{
		board[0] = new ArrayList<>();
		board[1] = new ArrayList<>();
	}
	
	
	public static boolean isPossible(int r, int c){
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	
	public static void dfs(int idx, int cnt, int resIdx){
		if(idx == board[resIdx].size()) return;
		for(int i=idx; i<board[resIdx].size(); ++i){
			int r = board[resIdx].get(i) / N, c = board[resIdx].get(i) % N;
			if(arr[r][c] != 0) continue;
			
			
			arr[r][c] = 2;
			// 0 -> 1
			for(int j=1; j<N; ++j){
				if(isPossible(r-j,c-j) && arr[r-j][c-j] == 0) arr[r-j][c-j] = 1;
				if(isPossible(r-j,c+j) && arr[r-j][c+j] == 0) arr[r-j][c+j] = 1;
				if(isPossible(r+j,c-j) && arr[r+j][c-j] == 0) arr[r+j][c-j] = 1;
				if(isPossible(r+j,c+j) && arr[r+j][c+j] == 0) arr[r+j][c+j] = 1;
			}
			
			res[resIdx] = Math.max(res[resIdx], cnt+1);
//			boolean isNext = false;
//			for(int j=i+2; j<NN && !isNext; j+=2)
//				if(arr[j/N][j%N] == 0) isNext = true;
//
//			if(isNext)
				dfs(i+1, cnt+1, resIdx);
			
			arr[r][c] = 0;
			// 1 -> 0
			for(int j=1; j<N; ++j){
				if(isPossible(r-j,c-j) && arr[r-j][c-j] == 1) {
					boolean flag = true;
					for(int k=1; k<N && flag; ++k){
//						if(isPossible(r-j-k, c-j-k) && arr[r-j-k][c-j-k] == 2) flag = false;
						if(isPossible(r-j-k, c-j+k) && arr[r-j-k][c-j+k] == 2) flag = false;
						if(isPossible(r-j+k, c-j-k) && arr[r-j+k][c-j-k] == 2) flag = false;
//						if(isPossible(r-j+k, c-j+k) && arr[r-j+k][c-j+k] == 2) flag = false;
					}
					if(flag) arr[r-j][c-j] = 0;
				}
				if(isPossible(r-j,c+j) && arr[r-j][c+j] == 1) {
					boolean flag = true;
					for(int k=1; k<N && flag; ++k){
						if(isPossible(r-j-k, c+j-k) && arr[r-j-k][c+j-k] == 2) flag = false;
//						if(isPossible(r-j-k, c+j+k) && arr[r-j-k][c+j+k] == 2) flag = false;
//						if(isPossible(r-j+k, c+j-k) && arr[r-j+k][c+j-k] == 2) flag = false;
						if(isPossible(r-j+k, c+j+k) && arr[r-j+k][c+j+k] == 2) flag = false;
					}
					if(flag) arr[r-j][c+j] = 0;
				}
				if(isPossible(r+j,c-j) && arr[r+j][c-j] == 1) {
					boolean flag = true;
					for(int k=1; k<N && flag; ++k){
						if(isPossible(r+j-k, c-j-k) && arr[r+j-k][c-j-k] == 2) flag = false;
//						if(isPossible(r+j-k, c-j+k) && arr[r+j-k][c-j+k] == 2) flag = false;
//						if(isPossible(r+j+k, c-j-k) && arr[r+j+k][c-j-k] == 2) flag = false;
						if(isPossible(r+j+k, c-j+k) && arr[r+j+k][c-j+k] == 2) flag = false;
					}
					if(flag) arr[r+j][c-j] = 0;
				}
				if(isPossible(r+j,c+j) && arr[r+j][c+j] == 1) {
					boolean flag = true;
					for(int k=1; k<N && flag; ++k){
//						if(isPossible(r+j-k, c+j-k) && arr[r+j-k][c+j-k] == 2) flag = false;
						if(isPossible(r+j-k, c+j+k) && arr[r+j-k][c+j+k] == 2) flag = false;
						if(isPossible(r+j+k, c+j-k) && arr[r+j+k][c+j-k] == 2) flag = false;
//						if(isPossible(r+j+k, c+j+k) && arr[r+j+k][c+j+k] == 2) flag = false;
					}
					if(flag) arr[r+j][c+j] = 0;
				}
			}
		}
	}
	
	public static void BOJ01799(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		N = Integer.parseInt(br.readLine());
		NN = N*N;
		int idx = 0;
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				if("0".equals(st.nextToken())) arr[i][j] = -1;
				board[idx].add(i*N+j);
				idx ^= 1;
			}
			if((N&1) != 1) idx ^= 1;
		}
		
		System.out.println(board[0]);
		System.out.println(board[1]);
		
		dfs(0, 0, 0);
		dfs(0, 0, 1);
		
		System.out.println(Arrays.toString(res));
		
		System.out.println(res[0] + res[1]);
		
		sc.close();
		bw.close();
		br.close();
	}
}
