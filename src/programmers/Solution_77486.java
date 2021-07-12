package programmers;
import java.util.HashMap;
import java.util.Map;

public class Solution_77486 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/77486
	 * name : 다단계 칫솔 판매
	 */
	
	int size;
	int[] sellPriceArr;
	int[] par;
	Map<String, Integer> peopleIdxMap = new HashMap<>();
	
	void addPrice(int idx, int price){
		int remainPrice = price / 10;
		if(idx == 0 || remainPrice == 0) {
			sellPriceArr[idx] += price;
			return;
		}
		
		sellPriceArr[idx] += price - remainPrice;
		addPrice(par[idx], remainPrice);
	}
	
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		size = enroll.length + 1;
		sellPriceArr = new int[size];
		par = new int[size];
		par[0] = -1;
		peopleIdxMap.put("-", 0);
		
		for(int i=0, idx=1; i<size-1; ++i){
			String p1 = enroll[i], p2 = referral[i];
			if(!peopleIdxMap.containsKey(p1))
				peopleIdxMap.put(p1, idx++);
			
			if(!peopleIdxMap.containsKey(p2))
				peopleIdxMap.put(p2, idx++);
			
			int idx1 = peopleIdxMap.get(p1), idx2 = peopleIdxMap.get(p2);
			par[idx1] = idx2;
		}
		
		for(int i=0; i<seller.length; ++i){
			String pe = seller[i];
			int price = amount[i] * 100;
			addPrice(peopleIdxMap.get(pe), price);
		}
		
		int[] answer = new int[size-1];
		for(int i=1; i<size; ++i) answer[i-1] = sellPriceArr[i];
		return answer;
	}
}