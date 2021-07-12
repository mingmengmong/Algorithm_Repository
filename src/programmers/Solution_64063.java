package programmers;
import java.util.HashMap;
import java.util.Map;


public class Solution_64063 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/64063
	 * name : 호텔 방 배정
	 */
	
	/**
	 * union-find : array 가 아닌 map 으로 해결
	 */
	
	Map<Long, Long> map = new HashMap<>();
	long add(long l){
		if(!map.containsKey(l)) {
			map.put(l,l);
			return l;
		}
		if(map.get(l) == l) return l;
		long res = add(map.get(l));
		map.put(l, res);
		return res;
	}
	
	long find(long l){
		if(!map.containsKey(l)){
			long ll = l+1;
			map.put(l, ll);
			add(l);
			return l;
		}else{
			long ll = l;
			while(map.get(ll) != ll) ll = map.get(ll);
			map.put(ll, ll+1);
			add(l);
			return ll;
		}
	}
	
	public long[] solution(long k, long[] room_number) {
		int roomLength = room_number.length;
		long[] res = new long[roomLength];
		
		for(int i=0; i<roomLength; ++i){
			long l = room_number[i];
			res[i] = find(l);
		}
		
		return res;
	}
}