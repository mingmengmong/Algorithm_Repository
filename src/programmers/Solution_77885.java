import java.util.*;
import java.text.*;
import java.util.stream.Collectors;


public class Solution {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/77885
	 * name : 2개 이하로 다른 비트
	 */
	
	public long[] solution(long[] numbers) {
		int N = numbers.length;
		long[] answer = new long[N];
		
		for(int i=0; i<N; ++i){
			long n = numbers[i];
			int cnt = 0;
			for(long idx=1; (n&idx) > 0 ; idx <<= 1, ++cnt);
			if(cnt == 0) answer[i] = n + 1;
			else answer[i] = n + (long) Math.pow(2, cnt-1);
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
//		System.out.println(Arrays.toString(s.solution(new long[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15})));
	}
}