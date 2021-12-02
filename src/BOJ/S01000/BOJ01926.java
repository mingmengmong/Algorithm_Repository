import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ01926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	static int N, M, MAX=500;
	static boolean[][] arr = new boolean[MAX+1][MAX+1], visit = new boolean[MAX+1][MAX+1];
	
	static boolean isPossible(int r, int c){
		return 0<=r&&r<N && 0<=c&&c<M;
	}
	
	static int dfs(int r, int c){
		if(visit[r][c]) return 0;
		visit[r][c] = true;
		int cnt = 1;
		for(int i=0; i<4; ++i){
			int nr = r + RD[i];
			int nc = c + CD[i];
			if(!isPossible(nr,nc)) continue;
			if(!arr[nr][nc] || visit[nr][nc]) continue;
			cnt += dfs(nr,nc);
		}
		return cnt;
	}
			
	public static void BOJ01926(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				arr[i][j] = "1".equals(st.nextToken());
			}
		}
		
		int cnt = 0;
		int area = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j){
				if(arr[i][j] && !visit[i][j]){
					++cnt;
					area = Math.max(area, dfs(i,j));
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(area);
		
		
		br.close();
		bw.close();
		sc.close();
	}
}