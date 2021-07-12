package programmers;
import java.util.*;

public class Solution_72411 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/72411
	 * name : 메뉴 리뉴얼
	 */
	
	static Map<String, Integer>[] stringCountMap = new Map[11];
	static{
		for(int i=1; i<=10; ++i) stringCountMap[i] = new HashMap<>();
	}
	
	char[] arr;
	
	void dfs(int idx, int arrIdx, int length, String word){
		if(arrIdx == length){
			String str = "";
			for(char c : arr) str += c;
			stringCountMap[length].put(str, stringCountMap[length].getOrDefault(str, 0) + 1);
			return;
		}
		
		int wordLength = word.length();
		for(int i=idx; i<wordLength; ++i){
			char c = word.charAt(i);
			arr[arrIdx] = c;
			dfs(i+1, arrIdx+1, length, word);
		}
	}
	
	class Node{
		public String word;
		public int cnt;
		public Node(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
	}
	
	public String[] solution(String[] orders, int[] courses) {
		for(String order : orders){
			char[] odarr = order.toCharArray();
			Arrays.sort(odarr);
			String sortOrder = new String(odarr);
			for(int course : courses){
				if(sortOrder.length() >= course){
					arr = new char[course];
					dfs(0, 0, course, sortOrder);
				}
			}
		}
		
		List<String> resultList = new ArrayList<>();
		for(int course : courses){
			Map<String, Integer> iter = stringCountMap[course];
			if(iter.isEmpty()) continue;
			
			List<Node> list = new ArrayList<>();
			for(String word : iter.keySet())
				if(iter.get(word) > 1) list.add(new Node(word, iter.get(word)));
			
			if(list.isEmpty()) continue;
			list.sort((n1, n2) -> Integer.compare(n2.cnt, n1.cnt));
			int length = list.get(0).cnt;
			for(Node iter2 : list){
				if(iter2.cnt != length) break;
				resultList.add(iter2.word);
			}
		}
		
		resultList.sort(String::compareTo);
		return resultList.toArray(new String[resultList.size()]);
	}
}