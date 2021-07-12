package programmers;

public class Solution_12985 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/12985
	 * name : 예상 대진표
	 */
	
	public int solution(int n, int a, int b){
		int res = 0;
		--a; --b;
		while(a != b){
			a >>>= 1;
			b >>>= 1;
			++res;
		}
		
		return res;
	}
}