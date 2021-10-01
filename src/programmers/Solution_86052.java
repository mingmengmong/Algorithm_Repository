import java.util.*;
import java.text.*;
import java.util.stream.*;


public class Solution {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/86052?language=java
	 * name : 빛의 경로 사이클
	 */
	
	// 반시계 방향. left = +1, right = -1
	static int[] RD = {1, 0, -1, 0}, CD = {0, 1, 0, -1};
	
	static int N, M;
	static char[][] board;
	static boolean[][][] visit;
	
	public int[] solution(String[] grid) {
		N = grid.length;
		M = grid[0].length();
		board = new char[N][];
		for(int i=0; i<N; ++i){
			board[i] = grid[i].toCharArray();
		}
		visit = new boolean[N][M][4];
		List<Integer> res = new ArrayList<>();
		
		for(int r=0; r<N; ++r){
			for(int c=0; c<M; ++c){
				for(int i=0; i<4; ++i){
					if(!visit[r][c][i]){
						int nr = r;
						int nc = c;
						int ni = i;
						int cnt = 0;
						for(; !visit[nr][nc][ni]; ++cnt){
							visit[nr][nc][ni] = true;
							if(board[nr][nc] == 'L'){
								ni = (ni+1) % 4;
							}else if(board[nr][nc] == 'R'){
								ni = (ni-1+4) % 4;
							}
							
							nr = (nr + RD[ni] + N) % N;
							nc = (nc + CD[ni] + M) % M;
						}
						res.add(cnt);
					}
				}
			}
		}
		
		res.sort(Integer::compareTo);
		return res.stream().flatMapToInt(IntStream::of).toArray();
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		System.out.println();
		//
	}
}