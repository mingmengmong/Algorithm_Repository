package programmers;


public class Solution_42897 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/42897
	 * name : 도둑질
	 */
	
	/*
	0번 집을 털고 안털고 유무
	현재 내 집을 털고 안털고 유무
	0 : 0번을 안털고 내집 안텀
	1 : 0번을 안털고 내집 텀
	2 : 0번을 털고  내집 안텀
	3 : 0번을 털고  내집 텀
	 */
	
	public int solution(int[] money) {
		int N = money.length;
		int[][] dp = new int[N+2][4];
		dp[0][3] = money[0];
		// 0 과 마지막집 관계를 제외하곤 멀 털든 상관이 없다.
		for(int i=1; i<N; ++i){
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = dp[i-1][0] + money[i];
			dp[i][2] = Math.max(dp[i-1][2], dp[i-1][3]);
			dp[i][3] = dp[i-1][2] + money[i];
		}
		
		return Math.max(dp[N-1][1], dp[N-1][2]);
	}

 	public static void main(String[] args){
// 		Solution sol = new Solution();
 	}
}