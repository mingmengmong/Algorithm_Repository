package programmers;
import java.util.Arrays;

public class Solution_77485 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/77485
	 * name : 행렬 테두리 회전하기
	 */
	
	int R,C;
	int[][] board;
	
	void setUp(int row, int col){
		R = row; C = col;
		board = new int[R][C];
		for(int r=0; r<R; ++r){
			for(int c=0; c<C; ++c){
				board[r][c] = 1 + r*C + c;
			}
			System.out.println(Arrays.toString(board[r]));
		}
	}
	
	int rotation(int x1, int y1, int x2, int y2){
		int min = board[x1][y1];
		int temp = board[x1][y1];
		
		for(int x=x1; x<x2; ++x){
			board[x][y1] = board[x+1][y1];
			min = Math.min(min, board[x][y1]);
		}
		
		for(int y=y1; y<y2; ++y){
			board[x2][y] = board[x2][y+1];
			min = Math.min(min, board[x2][y]);
		}
		
		for(int x=x2; x>x1; --x){
			board[x][y2] = board[x-1][y2];
			min = Math.min(min, board[x][y2]);
		}
		
		for(int y=y2; y>y1; --y){
			board[x1][y] = board[x1][y-1];
			min = Math.min(min, board[x1][y]);
		}
		
		board[x1][y1+1] = temp;
		
		return min;
	}
	
	public int[] solution(int rows, int columns, int[][] queries) {
		setUp(rows, columns);
		
		int[] answer = new int[queries.length];
		for(int i=0; i<answer.length; ++i){
			int[] query = queries[i];
			answer[i] = rotation(
					query[0]-1, query[1]-1, query[2]-1, query[3]-1
			);
		}
		
		return answer;
	}
}