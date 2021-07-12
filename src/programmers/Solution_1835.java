package programmers;
import java.util.ArrayList;
import java.util.List;

public class Solution_1835 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/1835
	 * name : 단체사진 찍기
	 */
	
	String[] name = {"A","C","F","J","M","N","R","T"};
	int[] nameArr = {0,-1,1,-1,-1,2,-1,-1,-1,3,-1,-1,4,5,-1,-1,-1,6,-1,7,-1,-1,-1,-1,-1,-1};
	int[] idxArr = new int[8];
	boolean[] visit = new boolean[8];
	int[] arr = new int[8];
	
	List<String> list = new ArrayList<>();
	
	void dfs(int length){
		if(length == 8){
//			System.out.println(Arrays.toString(arr));
			String str = "";
			for(int i=0; i<8; ++i)
				str += arr[i];
			list.add(str);
			
			return;
		}
		
		for(int i=0; i<8; ++i){
			if(!visit[i]){
				visit[i] = true;
				
				arr[length] = i;
				dfs(length+1);
				
				visit[i] = false;
			}
		}
	}
	
	
	
	public int solution(int n, String[] data) {
		dfs(0);
		
		int answer = 0;
		a : for(String line : list){
			for(int i=0; i<8; ++i){
				idxArr[line.charAt(i) - '0'] = i;
			}
			
			for(String query : data){
				int idx1 = idxArr[nameArr[query.charAt(0) - 'A']];
				int idx2 = idxArr[nameArr[query.charAt(2) - 'A']];
				char operator = query.charAt(3);
				int length = query.charAt(4) - '0' + 1;
				
				if(operator == '='){
					if(!(Math.abs(idx1-idx2) == length)) continue a;
				}else if(operator == '<'){
					if(!(Math.abs(idx1-idx2) < length)) continue a;
				}else{
					if(!(Math.abs(idx1-idx2) > length)) continue a;
				}
			}
			
			++answer;
		}
		
		return answer;
	}
}