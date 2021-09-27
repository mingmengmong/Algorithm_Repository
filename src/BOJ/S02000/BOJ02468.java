import java.io.*;
import java.util.*;

public class BOJ02468 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	static int N;
	
	static boolean isPossible(int r, int c){
		return 0<=r&&r<N && 0<=c&&c<N;
	}
	static void dfs(int r, int c, boolean[][] visit){
		if(visit[r][c]) return;
		visit[r][c] = true;
		for(int i=0; i<4; ++i){
			int nr = r + RD[i];
			int nc = c + CD[i];
			if(!isPossible(nr, nc)) continue;
			if(visit[nr][nc]) continue;
			dfs(nr,nc,visit);
		}
	}
	
	public static void BOJ02468(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int min = 100, max = 0;
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}
		
		int res = 1;
		for(int i=min; i<max; ++i){
			boolean[][] visit = new boolean[N][N];
			for(int r=0; r<N; ++r){
				for(int c=0; c<N; ++c){
					visit[r][c] = arr[r][c] <= i;
				}
			}
			int cnt = 0;
			for(int r=0; r<N; ++r){
				for(int c=0; c<N; ++c){
					if(!visit[r][c]){
						++cnt;
						dfs(r,c, visit);
					}
				}
			}
			res = Math.max(res, cnt);
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}