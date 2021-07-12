package programmers;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_64065 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/64065
	 * name : 튜플
	 */
	
	public int[] solution(String s) {
		StringBuffer sb = new StringBuffer(s);
		sb.delete(s.length()-2, s.length()).delete(0, 2);
		
		String[] spl = sb.toString().split("\\},\\{");
		Arrays.sort(spl, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
		
		int length = spl.length;
		Set<Integer> set = new HashSet<>();
		int[] res = new int[length];
		for(int i=0; i<length; ++i){
			String[] numArr = spl[i].split(",");
			for(String numStr : numArr){
				int num = Integer.parseInt(numStr);
				if(!set.contains(num)){
					res[i] = num;
					set.add(num);
					break;
				}
			}
		}
		
		return res;
	}
}