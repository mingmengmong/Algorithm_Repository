package programmers;

public class Solution_1829 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/1829
	 * name : 카카오프렌즈 컬러링북
	 */
	
	int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	int R, C;
	int[][] B;
	boolean[][] visit;
	int resCnt = 0;
	int resMaxSize = 0;
	
	boolean check(int r, int c){
		return 0<=r && r<R && 0<=c && c<C;
	}
	
	int dfs(int r, int c, int idx){
		if(visit[r][c]) return 0;
		visit[r][c] = true;
		int cnt = 1;
		for(int i=0; i<4; ++i){
			int nr = r + RD[i];
			int nc = c + CD[i];
			if(!check(nr,nc) || B[nr][nc] != idx || visit[nr][nc]) continue;
			cnt += dfs(nr, nc, idx);
		}
		return cnt;
	}
	
	public int[] solution(int row, int col, int[][] board) {
		R = row; C = col; B = board;
		visit = new boolean[R][C];
		
		for(int r=0; r<R; ++r){
			for(int c=0; c<C; ++c){
				if(B[r][c] != 0 && !visit[r][c]){
					int size = dfs(r,c,B[r][c]);
					++resCnt;
					resMaxSize = Math.max(resMaxSize, size);
				}
			}
		}
		
		return new int[]{resCnt, resMaxSize};
	}
}