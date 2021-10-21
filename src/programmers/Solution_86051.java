import java.util.*;
import java.util.stream.*;


public class Solution {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/86051
	 * name : 없는 숫자 더하기
	 */
	
	public int solution(int[] numbers) {
		int answer = 45;
		for(int i : numbers) answer -= i;
		return answer;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		System.out.println();
		//
	}
}