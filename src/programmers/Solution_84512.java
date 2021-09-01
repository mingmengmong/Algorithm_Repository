package programmers;
import java.util.HashMap;
import java.util.Map;


public class Solution_84512 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/84512
	 * name : 5주차
	 */
	
	String[] arr = {"A", "E", "I", "O", "U"};
	Map<String, Integer> map = new HashMap<>();
	StringBuilder sb = new StringBuilder();
	int idx = 1;
	void init(int l){
		if(l == 5){
			return;
		}
		
		for(int i=0; i<5; ++i){
			sb.append(arr[i]);
			map.put(sb.toString(), idx++);
			init(l+1);
			sb.deleteCharAt(l);
		}
	}
	
	public int solution(String word) {
		init(0);
		return map.get(word);
	}
	
	public static void main(String[] args){
//		Solution s = new Solution();
	}
}