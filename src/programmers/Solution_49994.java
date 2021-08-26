package programmers;
import java.util.HashMap;
import java.util.Map;


public class Solution_49994 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/49994
	 * name : 방문 길이
	 */
	
	// 00 01
	// 10 11
	
	static int[] RD = {1,-1, 0,0}, CD = {0,0, 1,-1};
	static boolean[][][] visit = new boolean[11][11][4];
	static int r = 5, c = 5;
	static Map<Character, Integer> map = new HashMap<>();
	static{
		map.put('U', 0);
		map.put('D', 1);
		map.put('R', 2);
		map.put('L', 3);
	}
	
	boolean isPossible(int r, int c){
		return 0<=r&&r<=10 && 0<=c&&c<=10;
	}
	
	public int solution(String dirs) {
		int res = 0;
		
		for(char dir : dirs.toCharArray()){
			int di = map.get(dir);
			int nr = r + RD[di];
			int nc = c + CD[di];
			if(!isPossible(nr,nc)) continue;
			if(!visit[nr][nc][di]) ++res;
			visit[r][c][di^1] = visit[nr][nc][di] = true;
			r = nr;
			c = nc;
		}
		
		return res;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
//		s.solution(1000);
//		System.out.println(Arrays.toString(s.solution(5)));
	}
}