package programmers;
import java.util.Arrays;


public class Solution_42842 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/42842
	 * name : 카펫
	 */
	
	public int[] solution(int brown, int yellow) {
		brown >>>= 1;
		for(int i=2; i<brown; ++i){
			int w = brown - i - 1, h = i-1;
			System.out.println(w + " " + h);
			if(w*h == yellow){
				return new int[]{w+2, h+2};
			}
		}
		
		int[] answer = {};
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
//		System.out.println(Arrays.toString(s.solution(10, 2)));
	}
}