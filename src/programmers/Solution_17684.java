package programmers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


public class Solution_17684 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/17684
	 * name : 압축
	 */
	
	int lastIdx = 27;
	static Map<String, Integer> map = new HashMap<>();
	static{
		map.put("", 0);
		for(int i=0; i<26; ++i){
			char c = (char)('A' + i);
			map.put(String.valueOf(c), (i+1));
		}
	}
	
	public int[] solution(String msg) {
		List<Integer> res = new ArrayList<>();
		String str = String.valueOf(msg.charAt(0));
		for(int i=1; i<msg.length(); ++i){
			String c = String.valueOf(msg.charAt(i));
			String ss = str + c;
			if(!map.containsKey(ss)){
				map.put(ss, lastIdx++);
				res.add(map.get(str));
				str = c;
			}else{
				str = ss;
			}
		}
		res.add(map.get(str));
		return res.stream().flatMapToInt(IntStream::of).toArray();
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
	}
}