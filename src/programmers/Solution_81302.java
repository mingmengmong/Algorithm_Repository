package programmers;


public class Solution_81302 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/81302
	 * name : 거리두기 확인하기
	 */
	
	int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	
	boolean isPossible(int r, int c){
		return 0<=r&&r<5 && 0<=c&&c<5;
	}
	
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		
		for(int tc=0; tc<places.length; ++tc){
			int res = 1;
			
			char[][] board = new char[5][5];
			for(int r=0; r<5; ++r){
				board[r] = places[tc][r].toCharArray();
			}
			
			aaa : for(int r=0; r<5; ++r){
				for(int c=0; c<5; ++c){
					if(board[r][c] == 'X') continue;
					int peopleCnt = 0;
					if(board[r][c] == 'P') ++peopleCnt;
					
					for(int i=0; i<4; ++i){
						int nr = r + RD[i];
						int nc = c + CD[i];
						if(!isPossible(nr,nc)) continue;
						if(board[nr][nc] == 'P') ++peopleCnt;
					}
					
					if(peopleCnt >= 2){
						res = 0;
						break aaa;
					}
				}
			}
			
			answer[tc] = res;
		}
		
		return answer;
	}
}