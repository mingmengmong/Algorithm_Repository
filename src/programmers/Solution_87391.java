import java.util.*;

public class Solution_87391 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/87391
	 * name : 공 이동 시뮬레이션
	 */
	
	int[] RD = {0,0,1,-1}, CD = {1,-1,0,0};
	
	public long solution(int n, int m, int x, int y, int[][] queries) {
		long l = y, r = y;
		long b = x, t = x;
		
		long res = 0;
		boolean flag = true;
		for(int i=queries.length-1; i>=0; --i){
			int[] query = queries[i];
			int cmd = query[0];
			int length = query[1];
			if(cmd == 0){
				if(l != 0) l += length;
				r = Math.min(m-1, r+length);
			}else if(cmd == 1){
				if(r != m-1) r -= length;
				l = Math.max(0, l-length);
			}else if(cmd == 2){
				if(t != 0) t += length;
				b = Math.min(n-1, b+length);
			}else if(cmd == 3) {
				if(b != n-1) b -= length;
				t = Math.max(0, t-length);
			}
			
			if(l >= m || r < 0 || t >= n || b < 0) {
				flag = false;
				break;
			}
		}
		
		return !flag ? 0 : (r-l+1) * (b-t+1);
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		long res = s.solution(2,5,0,1, new int[][]{{3,1},{2,2},{1,1},{2,3},{0,1},{2,1}});
		
		System.out.println(res);
		//
	}
}