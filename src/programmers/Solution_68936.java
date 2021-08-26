package programmers;


public class Solution_68936 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/68936
	 * name : 쿼드압축 후 개수 세기
	 */
	
	int N;
	int[][] arr;
	int[] res = {0, 0};
	
	public void solve(int r, int c, int length){
		if(length == 1){
			++res[arr[r][c]];
			return;
		}
		
		boolean check = true;
		int pivot = arr[r][c];
		aaa : for(int i=0; i<length; ++i){
			int rr = r + i;
			for(int j=0; j<length; ++j){
				int cc = c + j;
				if(pivot != arr[rr][cc]){
					check = false;
					break aaa;
				}
			}
		}
		
		if(check){
			++res[pivot];
		}else{
			length >>>= 1;
			solve(r,c,length);
			solve(r+length,c,length);
			solve(r,c+length,length);
			solve(r+length,c+length,length);
		}
	}
	
	public int[] solution(int[][] input) {
		arr = input;
		N = arr.length;
		solve(0,0,N);
		return res;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
//		System.out.println(Arrays.toString(s.solution(new long[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15})));
	}
}