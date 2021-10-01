import java.util.*;
import java.util.stream.*;


public class Solution {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/12987
	 * name : 숫자 게임
	 */
	
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int N = A.length;
		int res = 0;
		for(int i=0, j=0; i<N && j<N; ++i){
			System.out.printf("%d vs %d\n", A[i], B[i]);
			if(A[i] < B[j]){
				++res;
				++j;
			}else{
				++j;
				--i;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		System.out.println();
		//
	}
}