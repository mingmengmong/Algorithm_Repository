package programmers;
import java.util.Arrays;


public class Solution_42747 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/42747
	 * name : H-Index
	 */
	
	public int lowerBound(int[] arr, int n){
		int l = 0, r = arr.length;
		while(l < r){
			int mid = (l+r) >>> 1;
			if(arr[mid] < n) l = mid + 1;
			else r = mid;
		}
		return l;
	}
	
	public int solution(int[] citations) {
		Arrays.sort(citations);
		int res = 0, l = citations.length;
		for(int i=l; i>=0; --i){
			int idx = lowerBound(citations, i);
			System.out.println(i + " " + idx + " " + (l-idx));
			if(i <= (l-idx)){
				res = i;
				break;
			}
		}
		
		int answer = 0;
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
//		System.out.println(s.solution(new int[]{3,1,0,5,6}));
	}
}