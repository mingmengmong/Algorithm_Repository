public class Solution {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/68646
	 * name : 풍선 터트리기
	 */
	
	int N;
	int[] dp1, dp2;
	
	public int solution(int[] a) {
		N = a.length;
		dp1 = new int[N +1];
		dp2 = new int[N +1];
		
		dp1[0] = a[0];
		dp2[N-1] = a[N-1];
		for(int i=1; i<N; ++i){
			dp1[i] = Math.min(a[i], dp1[i-1]);
			dp2[N-1-i] = Math.min(a[N-1-i], dp2[N-i]);
		}
		
		int res = 0;
		for(int i=0; i<N; ++i){
			if(a[i] <= dp1[i] || a[i] <= dp2[i]) ++res;
		}
		return res;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		System.out.println();
		//
	}
}