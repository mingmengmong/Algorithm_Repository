package programmers;
import java.util.HashSet;
import java.util.Set;

public class Solution_77484 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/77484
	 * name : 로또의 최고 순위와 최저 순위
	 */
	
	int getRate(int cnt){
		if(cnt == 6) return 1;
		else if(cnt == 5) return 2;
		else if(cnt == 4) return 3;
		else if(cnt == 3) return 4;
		else if(cnt == 2) return 5;
		else return 6;
	}
	
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = {};
		
		Set<Integer> set = new HashSet<>();
		for(int i : win_nums) set.add(i);
		
		int zeroCnt = 0;
		int cnt = 0;
		
		for(int num : lottos){
			if(num == 0) ++zeroCnt;
			else if(set.contains(num)) ++cnt;
		}
		
		return new int[]{getRate(cnt + zeroCnt), getRate(cnt)};
	}
}