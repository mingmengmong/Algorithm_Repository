package programmers;


public class Solution_82612 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/82612
	 * name : 부족한 금액 계산하기
	 */
	
	
	public long solution(int price, int money, int count) {
		long res = 0;
		for(long i=1; i<=count; ++i) res += i;
		res *= price;
		
		if(res <= money) return 0;
		return res - money;
	}
	
	public static void main(String[] args) throws Exception {
		// 10
//		System.out.println(new Solution().solution(2500, 20, 2500));
	}
}