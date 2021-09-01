package programmers;


public class Solution_77886 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/77886
	 * name : 110 옮기기
	 */
	
	public String[] solution(String[] sArr) {
		String[] answer = new String[sArr.length];
		for(int i=0; i<sArr.length; ++i) {
			String s = sArr[i];
			StringBuilder sb = new StringBuilder(s);
			int cnt = 0;
			int idx = -1;
			int fromIdx = 0;
			while((idx = sb.indexOf("110", fromIdx)) >= 0){
				++cnt;
				sb.delete(idx, idx+3);
				fromIdx = Math.max(idx-2, 0);
			}
			if(cnt == 0){
				answer[i] = s;
				continue;
			}
			String repeat = "110".repeat(cnt);
			idx = sb.lastIndexOf("0");
			if(idx < 0){
				answer[i] = repeat.concat(sb.toString());
			}else{
				System.out.println(idx);
				answer[i] = sb.insert(idx, repeat).toString();
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args){
//		Solution s = new Solution();
	
	}
}