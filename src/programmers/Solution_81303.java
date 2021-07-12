package programmers;
import java.util.Stack;


public class Solution_81303 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/81303
	 * name : 표 편집
	 */
	
	public String solution(int n, int k, String[] cmdArr) {
		int[] left = new int[n];
		int[] right = new int[n];
		for(int i=0; i<n; ++i) {
			left[i] = i - 1;
			right[i] = i + 1;
		}
		
		Stack<Integer> st = new Stack<>();
		for(String cmdIter : cmdArr){
			String[] cmdSpl = cmdIter.split(" ");
			if("U".equals(cmdSpl[0])){
				// left
				int num = Integer.parseInt(cmdSpl[1]);
				for(int i=0; i<num; ++i) k = left[k];
			}else if("D".equals(cmdSpl[0])){
				// right
				int num = Integer.parseInt(cmdSpl[1]);
				for(int i=0; i<num; ++i) k = right[k];
			}else if("C".equals(cmdSpl[0])){
				// delete
				st.push(k);
				if(left[k] == -1){
					left[right[k]] = left[k];
//					right[left[k]] = right[k];
					k = right[k];
				}else if(right[k] == n){
//					left[right[k]] = left[k];
					right[left[k]] = right[k];
					k = left[k];
				}else{
					left[right[k]] = left[k];
					right[left[k]] = right[k];
					k = right[k];
				}
			}else if("Z".equals(cmdSpl[0])){
				// restore
				int num = st.pop();
				if(left[num] == -1){
					left[right[num]] = num;
//					right[left[num]] = num;
				}else if(right[num] == n){
//					left[right[num]] = num;
					right[left[num]] = num;
				}else{
					left[right[num]] = num;
					right[left[num]] = num;
				}
			}
		}
		
		boolean[] bArr = new boolean[n];
		while(!st.isEmpty()) bArr[st.pop()] = true;
		
		StringBuilder sb = new StringBuilder();
		for(boolean b : bArr) sb.append(b ? "X" : "O");
		
		return sb.toString();
	}
}