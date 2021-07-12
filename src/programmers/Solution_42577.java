package programmers;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_42577 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/42577
	 * name : 전화번호 목록
	 */
	
	static Set<String>[] set = new Set[21];
	static {
		for(int i = 1; i<=20; ++i)
			set[i] = new HashSet<>();
	}
	
	public boolean solution(String[] pb) {
		Arrays.sort(pb, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
		for(String phone : pb){
			int length = phone.length();
			String subPhone = "";
			for(int i=1; i<=length; ++i){
				subPhone += phone.charAt(i-1);
				if(set[i].isEmpty()) continue;
				if(set[i].contains(subPhone)) return false;
			}
			set[length].add(phone);
		}
		
		return true;
	}
}