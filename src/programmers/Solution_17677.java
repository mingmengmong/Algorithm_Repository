package programmers;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Solution_17677 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/17677
	 * name : [1차] 뉴스 클러스터링
	 */
	
	private final static int MUL_NUM = 65536;
	
	boolean isPossible(char c){
		return 'a' <= c && c <= 'z';
	}
	
	public int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		Map<String, Integer> str1Map = new HashMap<>();
		Map<String, Integer> unionMap = new HashMap<>();
		for(int i=0; i<str1.length()-1; ++i){
			char c1 = str1.charAt(i);
			char c2 = str1.charAt(i+1);
			if(!isPossible(c1) || !isPossible(c2)) continue;
			
			String subStr1 = "" + c1 + c2;
			str1Map.put(subStr1, str1Map.getOrDefault(subStr1, 0) + 1);
			unionMap.put(subStr1, str1Map.get(subStr1));
		}
		
		Map<String, Integer> str2Map = new HashMap<>();
		for(int i=0; i<str2.length()-1; ++i){
			char c1 = str2.charAt(i);
			char c2 = str2.charAt(i+1);
			if(!isPossible(c1) || !isPossible(c2)) continue;
			
			String subStr2 = "" + c1 + c2;
			str2Map.put(subStr2, str2Map.getOrDefault(subStr2, 0) + 1);
		}
		
		Map<String, Integer> joinMap = new HashMap<>();
		for(String str2MapKey : str2Map.keySet()){
			if(str1Map.containsKey(str2MapKey)){
				int str1MapValue = str1Map.get(str2MapKey);
				int str2MapValue = str2Map.get(str2MapKey);
				joinMap.put(str2MapKey, Math.min(str1MapValue, str2MapValue));
				unionMap.put(str2MapKey, Math.max(str1MapValue, str2MapValue));
			}else{
				unionMap.put(str2MapKey, str2Map.get(str2MapKey));
			}
		}
		
		if(unionMap.isEmpty()) return MUL_NUM;
		
		int joinSize = 0;
		for(int value : joinMap.values()) joinSize += value;
		int unionSize = 0;
		for(int value : unionMap.values()) unionSize += value;
		
		return MUL_NUM * joinSize / unionSize;
	}
	
	public int solution2(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		Map<String, Integer> str1Map = new HashMap<>();
		for(int i=0; i<str1.length()-1; ++i){
			char c1 = str1.charAt(i);
			char c2 = str1.charAt(i+1);
			if(!isPossible(c1) || !isPossible(c2)) continue;
			
			String subStr1 = "" + c1 + c2;
			str1Map.put(subStr1, str1Map.getOrDefault(subStr1, 0) + 1);
		}
		
		Map<String, Integer> str2Map = new HashMap<>();
		for(int i=0; i<str2.length()-1; ++i){
			char c1 = str2.charAt(i);
			char c2 = str2.charAt(i+1);
			if(!isPossible(c1) || !isPossible(c2)) continue;
			
			String subStr2 = "" + c1 + c2;
			str2Map.put(subStr2, str2Map.getOrDefault(subStr2, 0) + 1);
		}
		
		Set<String> joinSet = new HashSet<>(str1Map.keySet());
		joinSet.retainAll(str2Map.keySet());
		Set<String> unionSet = new HashSet<>(str1Map.keySet());
		unionSet.addAll(str2Map.keySet());
		
		if(unionSet.isEmpty()) return MUL_NUM;
		
		int joinSize = 0;
		for(String key : joinSet){
			joinSize += Math.min(str1Map.get(key), str2Map.get(key));
		}
		int unionSize = 0;
		for(String key : unionSet){
			unionSize += Math.max(str1Map.getOrDefault(key, 0), str2Map.getOrDefault(key, 0));
		}
		
		return MUL_NUM * joinSize / unionSize;
	}
}