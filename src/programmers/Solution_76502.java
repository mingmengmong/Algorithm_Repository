package programmers;
import java.util.Stack;

public class Solution_76502 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/76502
	 * name : 괄호 회전하기
	 */
	
	public int solution(String s) {
		if(s.length() % 2 == 1) return 0;
		
		int[] bracketCnt = new int[3];
		for(char c : s.toCharArray()){
			if(c == '(') ++bracketCnt[0];
			else if(c == ')') --bracketCnt[0];
			else if(c == '[') ++bracketCnt[1];
			else if(c == ']') --bracketCnt[1];
			else if(c == '{') ++bracketCnt[2];
			else if(c == '}') --bracketCnt[2];
		}
		if(bracketCnt[0] != 0 || bracketCnt[1] != 0 || bracketCnt[2] != 0) return 0;
		
		int res = 0;
		StringBuffer sb = new StringBuffer(s);
		a : for(int i=0; i<s.length(); ++i) {
			sb = sb.append(sb.charAt(0)).deleteCharAt(0);
			
			Stack<Integer> st = new Stack<>();
			for(int j=0; j<s.length(); ++j){
				int cIdx = ((int)sb.charAt(j) + 1) >>> 1;
				if(cIdx == 46 || cIdx == 20 || cIdx == 62){
					st.push(cIdx);
				}else{
					if(st.isEmpty() || st.peek() != cIdx-1) continue a;
					st.pop();
				}
			}
			
			++res;
		}
		
		return res;
	}
}