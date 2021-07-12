package programmers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution_64064 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/64064
	 * name : 불량 사용자
	 */
	
	List<Integer>[] banList;
	Set<Integer> set = new HashSet<>();
	Set<String> resSet = new HashSet<>();
	
	void dfs(int idx){
		if(idx == banList.length){
			List<Integer> list = new ArrayList<>(set);
			list.sort(Integer::compareTo);
			resSet.add(list.toString());
			return;
		}
		
		for(int i : banList[idx]){
			if(!set.contains(i)){
				set.add(i);
				dfs(idx+1);
				set.remove(i);
			}
		}
	}
	
	public int solution(String[] user_id, String[] banned_id) {
		banList = new List[banned_id.length];
		for(int i=0; i< banned_id.length; ++i){
			String pattern = banned_id[i];
			banList[i] = new ArrayList<>();
			for(int k=0; k<user_id.length; ++k){
				String id = user_id[k];
				if(pattern.length() != id.length()) continue;
				boolean flag = true;
				for(int j=0; flag && j<pattern.length(); ++j){
					char pc = pattern.charAt(j);
					char uc = id.charAt(j);
					if(pc == '*') continue;
					if(pc != uc) {
						flag = false;
						break;
					}
				}
				if(flag) banList[i].add(k);
			}
		}
		
		dfs(0);
		
		return resSet.size();
	}
}