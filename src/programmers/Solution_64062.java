package programmers;
import java.util.Arrays;


public class Solution_64062 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/64062
	 * name : 징검다리 건너기
	 */
	
	public int solution(int[] stones, int k) {
		int size = stones.length;
		int[][] arr = new int[size][2];
		int[] left = new int[size];
		int[] right = new int[size];
		for(int i=0; i<size; ++i){
			arr[i][0] = stones[i];
			arr[i][1] = i;
			left[i] = i-1;
			right[i] = i+1;
		}
		
		Arrays.sort(arr, (ar1, ar2) -> {
			if(ar1[0] == ar2[0]) return Integer.compare(ar1[1], ar2[1]);
			return Integer.compare(ar1[0], ar2[0]);
		});
		
		for(int[] iter : arr){
			int stone = iter[0];
			int idx = iter[1];
			
//			if((idx - left[idx]) > k || (right[idx] - idx) > k) return stone;
			if(left[idx] != -1){
				right[left[idx]] = right[idx];
			}
			if(right[idx] != size){
				left[right[idx]] = left[idx];
			}
			
			if(right[idx] - left[idx] > k) return stone;
		}
		
		return 0;
	}
}