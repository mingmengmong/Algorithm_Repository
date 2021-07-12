package programmers;
import java.util.Arrays;


public class Solution_43238 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/43238
	 * name : 입국심사
	 */
	
	public long solution(long n, int[] times) {
		Arrays.sort(times);
		long l = 0, r = n * times[times.length-1];
		
		while(l < r){
			long tmp = 0;
			long mid = (l+r) >>> 1;
			for(long time : times){
				tmp += Math.floorDiv(mid, time);
			}
			
			if(tmp >= n) r = mid;
			else l = mid+1;
		}
		
		return l;
	}
}