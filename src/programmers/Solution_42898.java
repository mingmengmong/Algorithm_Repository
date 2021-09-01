package programmers;


public class Solution_42898 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/42898
	 * name : 등굣길
	 */
	
	int MOD=1_000_000_007;
	
	public int solution(int n, int m, int[][] puddles) {
		int[][] dp = new int[n+1][m+1];
		for(int[] iter : puddles){
			int r = iter[0];
			int c = iter[1];
			dp[r][c] = -1;
		}
		
		dp[1][1] = 1;
		for(int i=1; i<=n; ++i){
			for(int j=1; j<=m; ++j){
				if(dp[i][j] == -1) continue;
				if(dp[i-1][j] != -1) {
					dp[i][j] += dp[i - 1][j];
					dp[i][j] %= MOD;
				}
				if(dp[i][j-1] != -1) {
					dp[i][j] += dp[i][j - 1];
					dp[i][j] %= MOD;
				}
			}
		}
		
		return dp[n][m];
	}
	
	public static void main(String[] args){
//		Solution s = new Solution();
	}
}