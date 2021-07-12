package programmers;
import java.util.*;


public class Solution_42890 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/42890
	 * name : 후보키
	 */
	
	int size, rowSize;
	boolean[] isUse;
	int[] tupleIdxArr;
	List<int[]> tupleList = new ArrayList<>();
	List<int[]> possibleTupleList = new ArrayList<>();
	
	boolean isPossible(int[] idxArr){
		for(int[] iter : possibleTupleList){
			int cnt = 0;
			for(int idx : idxArr){
				for(int pIdx : iter){
					if(idx == pIdx) ++cnt;
				}
			}
			if(cnt == iter.length) return false;
		}
		return true;
	}
	
	void func(int idx, int arrIdx){
		if(arrIdx == tupleIdxArr.length){
			tupleList.add(Arrays.copyOf(tupleIdxArr, tupleIdxArr.length));
			return;
		}
		
		if(idx == size) return;
		
		for(int i=idx; i<size; ++i){
			if(!isUse[i]){
				isUse[i] = true;
				
				tupleIdxArr[arrIdx] = i;
				func(i+1, arrIdx+1);
				
				isUse[i] = false;
			}
		}
	}
	
	public int solution(String[][] relation) {
		rowSize = relation.length;
		size = relation[0].length;
		isUse = new boolean[size];
		
		int res = 0;
		Set<String> set = new HashSet<>();
		for(int arrSize=1; arrSize<=size; ++arrSize){
			tupleList.clear();
			tupleIdxArr = new int[arrSize];
			func(0, 0);
			
			if(tupleList.isEmpty()) break;
			
			for(int[] iter : tupleList){
				set.clear();
				
				if(!isPossible(iter)) continue;
				
				for(String[] row : relation){
					String key = "";
					for(int idx : iter)
						key += row[idx];
					set.add(key);
				}
				
				if(set.size() == rowSize){
					++res;
					possibleTupleList.add(iter);
				}
			}
		}
		
		return res;
	}
}