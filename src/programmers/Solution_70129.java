package programmers;


public class Solution_70129 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/70129
	 * name : 이진 변환 반복하기
	 */
	
	public int[] solution(String s) {
		int[] res = {0, 0};
		
		while(!"1".equals(s)){
			int length = s.length();
			int delCnt = 0;
			for(char c : s.toCharArray()){
				if(c == '0'){
					++delCnt;
				}
			}
			
			length -= delCnt;
			s = Integer.toBinaryString(length);
			++res[0];
			res[1] += delCnt;
		}
		
		return res;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
		int i = 100_0000;
		System.out.println("T");
		System.out.println(Integer.toBinaryString(i));
	}
}