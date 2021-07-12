package programmers;
import java.util.ArrayList;
import java.util.List;


public class Solution_17679 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/17679
	 * name : [1차] 프렌즈4블록
	 */
	
	public int solution(int R, int C, String[] inputBoard) {
		int[][] board = new int[R][C];
		for(int r=0; r<R; ++r){
			for(int c=0; c<C; ++c)
				board[r][c] = inputBoard[r].charAt(c);
		}
		
		
		List<int[]> delList = new ArrayList<>();
		int res = 0;
		while(true){
			delList.clear();
			for(int r=0; r<R-1; ++r){
				for(int c=0; c<C-1; ++c){
					if(board[r][c] == 0) continue;
					if(board[r][c] != board[r+1][c] || board[r][c] != board[r][c+1] || board[r][c] != board[r+1][c+1]) continue;
					delList.add(new int[]{r,c});
				}
			}
			
			if(delList.isEmpty()) break;
			
			for(int[] iter : delList){
				int r = iter[0];
				int c = iter[1];
				
				if(board[r][c] != 0) ++res;
				if(board[r][c+1] != 0) ++res;
				if(board[r+1][c] != 0) ++res;
				if(board[r+1][c+1] != 0) ++res;
				
				board[r][c] = 0;
				board[r][c+1] = 0;
				board[r+1][c] = 0;
				board[r+1][c+1] = 0;
			}
			
			for(int c=0; c<C; ++c){
				int[] col = new int[R];
				for(int r=R-1, idx=R-1; r>=0; --r){
					if(board[r][c] != 0) col[idx--] = board[r][c];
				}
				
				for(int r=0; r<R; ++r) board[r][c] = col[r];
			}
		}
		
		return res;
	}
}