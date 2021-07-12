package programmers;

public class Solution_76501 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/76501
	 * name : 음양 더하기
	 */
	
	public int solution(int[] absolutes, boolean[] signs) {
		int res = 0;
		for(int i=0; i< absolutes.length; ++i)
			res += signs[i] ? absolutes[i] : -absolutes[i];
		return res;
	}
}