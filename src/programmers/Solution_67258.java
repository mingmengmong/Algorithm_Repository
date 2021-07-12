package programmers;
import java.util.*;


public class Solution_67258 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/67258
	 * name : 보석 쇼핑
	 */
	
	public int[] solution(String[] gems) {
		Set<String> gemSet = new HashSet<>();
		Collections.addAll(gemSet, gems);
		
		if(gems.length == gemSet.size())
			return new int[]{1, gems.length};
		
		/*
		2 포인터를 이용하여 모든 보석을 구매하는 경우에서 왼쪽에서 부터 땡기면서 확인을 한다.
		 */
		int gemSize = gemSet.size(), gemLength = gems.length;
		Map<String, Integer> map = new HashMap<>();
		int l=0, r=0;
		List<int[]> list = new ArrayList<>();
		while(r < gemLength){
			// map 에 저장
			map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
			
			// 모든 보석을 구매한 경우
			if(map.size() == gemSize){
				// 왼쪽부터 하나씩 땡긴다. 개수가 1개이면 스탑.
				while(l < r && map.get(gems[l]) != 1){
					map.put(gems[l], map.get(gems[l]) - 1);
					++l;
				}
				// 이때의 l,r 을 저장
				list.add(new int[]{l,r});
			}
			
			++r;
		}
		
//		for(int[] iter : list) System.out.println(Arrays.toString(iter));
		
		// r-l 이 작은 순, l 이 작은 순 정렬
		list.sort((arr1, arr2) -> {
			int l1 = arr1[1]-arr1[0], l2 = arr2[1]-arr2[0];
			if(l1 == l2) return Integer.compare(arr1[0], arr2[0]);
			return Integer.compare(l1, l2);
		});
		
		
		// idx + 1. 이건 상단에 추가시 +1 해줘도 된다.
		int[] res = list.get(0);
		return new int[]{res[0] + 1, res[1] + 1};
	}
}