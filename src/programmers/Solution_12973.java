package programmers;
import java.util.Stack;

public class Solution_12973 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/12973
	 * name : 짝지어 제거하기
	 */
	
	public int solution(String s){
		if(s.length() % 2 == 1) return 0;
		
		char[] ss = s.toCharArray();
		Stack<Character> st = new Stack<>();
		for(char c : ss){
			if(!st.isEmpty() && st.peek() == c) st.pop();
			else st.push(c);
		}
		
		return st.isEmpty() ? 1 : 0;
	}
}